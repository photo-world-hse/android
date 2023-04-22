package com.photoworld.presenter.createprofile.avatar

import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateProfileAvatarViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
) : ViewModel() {

    private var _imageState = mutableStateOf("")
    val imageState: State<String> = _imageState

    fun cancel() {
        navigationManager.newRoot(Screen.BottomNavigationScreen.Main.route)
    }

    fun nextScreen() {
        navigationManager.newRoot(Screen.BottomNavigationScreen.Profile.route)
    }

    fun onNewImage(uri: Uri?) {
        uri?.let {
            _imageState.value = uri.toString()
        }
    }

}