package com.photoworld.presenter.util

import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import com.photoworld.presenter.util.Authority.DownloadsDocumentAuthority
import com.photoworld.presenter.util.Authority.ExternalStorageDocumentAuthority
import com.photoworld.presenter.util.Authority.GooglePhotosUriAuthority
import com.photoworld.presenter.util.Authority.MediaDocumentAuthority
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

internal fun Context.getMultipartBodyByUri(uri: Uri): MultipartBody.Part? {
    val file = getFileByUri(uri)
    return file?.let {
        val requestBody =
            file.asRequestBody(contentType = "image/*".toMediaTypeOrNull())
        MultipartBody.Part.createFormData(
            name = "file",
            filename = file.name,
            body = requestBody,
        )
    }
}

internal fun Context.getFileByUri(uri: Uri): File? {
    val imagePath = getPathByUri(uri)
    return imagePath?.let { File(it) }
}

private fun Context.getPathByUri(uri: Uri): String? =
    when {
        DocumentsContract.isDocumentUri(this, uri) -> getPathFromDocumentUri(uri)
        uri.scheme?.lowercase() == "content" -> {
            if (uri.authority == GooglePhotosUriAuthority) {
                uri.lastPathSegment
            } else {
                getDataColumn(
                    uri = uri,
                    selection = null,
                    selectionArgs = null,
                )
            }
        }
        uri.scheme?.lowercase() == "file" -> uri.path
        else -> null
    }

private fun Context.getPathFromDocumentUri(uri: Uri): String? =
    when (uri.authority) {
        ExternalStorageDocumentAuthority -> {
            val docId = DocumentsContract.getDocumentId(uri)
            val split = docId.split(":").dropLastWhile { it.isEmpty() }
            Environment.getExternalStorageDirectory().absolutePath + "/" + split[1]
        }
        DownloadsDocumentAuthority -> {
            val id = DocumentsContract.getDocumentId(uri).toLong()
            val downloadsUri = Uri.parse("content://downloads/public_downloads")
            val contentUri = ContentUris.withAppendedId(downloadsUri, id)
            getDataColumn(contentUri, null, null)
        }
        MediaDocumentAuthority -> {
            val docId = DocumentsContract.getDocumentId(uri)
            val split = docId.split(":").dropLastWhile { it.isEmpty() }
            val contentUri = when (split[0]) {
                "image" -> MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                "video" -> MediaStore.Video.Media.EXTERNAL_CONTENT_URI
                "audio" -> MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                else -> null
            }
            contentUri?.let {
                getDataColumn(
                    uri = contentUri,
                    selection = "_id=?",
                    selectionArgs = arrayOf(split[1]),
                )
            }
        }
        else -> null
    }

private fun Context.getDataColumn(
    uri: Uri,
    selection: String?,
    selectionArgs: Array<String>?,
): String? {
    var cursor: Cursor? = null
    val column = "_data"
    val projection = arrayOf(
        column,
    )
    try {
        cursor = contentResolver.query(uri, projection, selection, selectionArgs, null)
        if (cursor != null && cursor.moveToFirst()) {
            val index = cursor.getColumnIndexOrThrow(column)
            return cursor.getString(index)
        }
    } finally {
        cursor?.close()
    }
    return null
}

private object Authority {
    const val ExternalStorageDocumentAuthority = "com.android.externalstorage.documents"
    const val DownloadsDocumentAuthority = "com.android.providers.downloads.documents"
    const val MediaDocumentAuthority = "com.android.providers.media.documents"
    const val GooglePhotosUriAuthority = "com.google.android.apps.photos.content"
}
