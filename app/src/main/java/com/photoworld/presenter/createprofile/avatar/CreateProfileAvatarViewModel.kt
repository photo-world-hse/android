package com.photoworld.presenter.createprofile.avatar

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.photoworld.domain.mapper.profile.ProfileTypeMapper
import com.photoworld.domain.usecase.profile.AddCreateProfileAvatarUrlUseCase
import com.photoworld.domain.usecase.profile.CreateProfileUseCase
import com.photoworld.domain.usecase.profile.UploadImageUseCase
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import javax.inject.Inject

@HiltViewModel
class CreateProfileAvatarViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val profileTypeMapper: ProfileTypeMapper,
    private val navigationManager: NavigationManager,
    private val uploadImageUseCase: UploadImageUseCase,
    private val addCreateProfileAvatarUrlUseCase: AddCreateProfileAvatarUrlUseCase,
    private val createProfileUseCase: CreateProfileUseCase,
) : ViewModel() {

    private var _imageState = mutableStateOf("")
    val imageState: State<String> = _imageState

    private val profileType = profileTypeMapper.map(
        profileTypeString = savedStateHandle[Screen.CreateProfileTag.PROFILE_TYPE_ARGUMENT] ?: ""
    )

    fun cancel() {
        navigationManager.newRoot(Screen.BottomNavigationScreen.Main.route)
    }

    fun nextScreen() {
        addCreateProfileAvatarUrlUseCase(_imageState.value)
        viewModelScope.launch {
            try {
                createProfileUseCase(profileType)
                navigationManager.newRoot(Screen.BottomNavigationScreen.Profile.route)
            } catch (error: Throwable) {
                println(error)
            }
        }
    }

    fun onNewImage(multipartBody: MultipartBody.Part?) {
        viewModelScope.launch {
            try {
                multipartBody?.let {
                    _imageState.value = uploadImageUseCase(file = multipartBody)
                }
            } catch (error: Throwable) {
                println(error)
            }
        }
    }

}