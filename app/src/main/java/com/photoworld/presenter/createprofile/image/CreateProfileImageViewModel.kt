package com.photoworld.presenter.createprofile.image

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.photoworld.domain.mapper.profile.ProfileTypeMapper
import com.photoworld.domain.usecase.profile.AddCreateProfilePhotosUseCase
import com.photoworld.domain.usecase.profile.UploadImageUseCase
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import javax.inject.Inject

@HiltViewModel
class CreateProfileImageViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val profileTypeMapper: ProfileTypeMapper,
    private val navigationManager: NavigationManager,
    private val uploadImageUseCase: UploadImageUseCase,
    private val addCreateProfilePhotosUseCase: AddCreateProfilePhotosUseCase,
) : ViewModel() {

    private var _imageState = mutableStateListOf<String>()
    val imageState: SnapshotStateList<String> = _imageState

    private val profileType = profileTypeMapper.map(
        profileTypeString = savedStateHandle[Screen.CreateProfileTag.PROFILE_TYPE_ARGUMENT] ?: ""
    )

    fun cancel() {
        navigationManager.newRoot(Screen.BottomNavigationScreen.Main.route)
    }

    fun nextScreen() {
        addCreateProfilePhotosUseCase(_imageState.toList())
        navigationManager.navigate(Screen.CreateProfileAvatar(profileType.value).route)
    }

    fun onNewImage(file: File?) {
        viewModelScope.launch {
            try {
                file?.let {
                    val requestBody =
                        file.asRequestBody(contentType = "image/*".toMediaTypeOrNull())
                    val multipartBody: MultipartBody.Part = MultipartBody.Part.createFormData(
                        name = "file",
                        filename = file.name,
                        body = requestBody,
                    )
                    val imageUrl = uploadImageUseCase(file = multipartBody)
                    _imageState.add(imageUrl)
                }
            } catch (error: Throwable) {
                println(error)
            }
        }
    }
}