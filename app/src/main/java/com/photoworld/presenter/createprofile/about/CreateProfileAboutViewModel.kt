package com.photoworld.presenter.createprofile.about

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.photoworld.domain.mapper.profile.ProfileTypeMapper
import com.photoworld.domain.usecase.profile.AddCreateProfileAboutInfoUseCase
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateProfileAboutViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val navigationManager: NavigationManager,
    private val profileTypeMapper: ProfileTypeMapper,
    private val addCreateProfileAboutInfoUseCase: AddCreateProfileAboutInfoUseCase,
) : ViewModel() {

    private val _aboutState = mutableStateOf("")
    val aboutState: State<String> = _aboutState

    private val _experienceState = mutableStateOf("")
    val experienceState: State<String> = _experienceState

    private val profileType = profileTypeMapper.map(
        profileTypeString = savedStateHandle[Screen.CreateProfileTag.PROFILE_TYPE_ARGUMENT] ?: ""
    )

    fun onAboutChange(newValue: String) {
        _aboutState.value = newValue
    }

    fun onExperienceChange(newValue: String) {
        _experienceState.value = newValue
    }

    fun cancel() {
        navigationManager.newRoot(Screen.BottomNavigationScreen.Main.route)
    }

    fun nextScreen() {
        addCreateProfileAboutInfoUseCase(
            aboutMe = _aboutState.value,
            workExperience = _experienceState.value.toDoubleOrNull() ?: 0.0,
        )
        navigationManager.navigate(Screen.CreateProfileImage(profileType.value).route)
    }
}