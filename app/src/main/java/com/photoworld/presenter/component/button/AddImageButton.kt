package com.photoworld.presenter.component.button

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.photoworld.R
import com.photoworld.presenter.theme.Gray500
import com.photoworld.presenter.util.getFileByUri
import java.io.File

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun AddImageButton(
    onResult: (file: File?) -> Unit
) {
    val context = LocalContext.current
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            uri?.let {
                val file = context.getFileByUri(uri)
                onResult(file)
            }
        }
    )
    val readExternalStoragePermissionState =
        rememberPermissionState(android.Manifest.permission.READ_EXTERNAL_STORAGE)
    BaseButton(
        text = stringResource(R.string.add_photo),
        backgroundColor = Gray500,
        onClick = {
            when {
                readExternalStoragePermissionState.status.isGranted ->
                    galleryLauncher.launch("image/*")
                readExternalStoragePermissionState.status.shouldShowRationale ->
                    readExternalStoragePermissionState.launchPermissionRequest()
                else -> Toast.makeText(
                    context,
                    R.string.need_read_external_storage_permission,
                    Toast.LENGTH_SHORT,
                ).show()
            }

        },
    )
    LaunchedEffect(Unit) {
        readExternalStoragePermissionState.launchPermissionRequest()
    }
}