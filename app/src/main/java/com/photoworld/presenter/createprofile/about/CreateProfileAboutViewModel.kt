package com.photoworld.presenter.createprofile.about

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateProfileAboutViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
) : ViewModel() {

    private val _aboutState = mutableStateOf("")
    val aboutState: State<String> = _aboutState

    private val _experienceState = mutableStateOf("")
    val experienceState: State<String> = _experienceState

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
        navigationManager.navigate(Screen.CreateProfileImage.route)
    }

}