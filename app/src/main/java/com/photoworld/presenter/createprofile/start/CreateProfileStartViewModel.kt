package com.photoworld.presenter.createprofile.start

import androidx.lifecycle.ViewModel
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateProfileStartViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
) : ViewModel() {

    fun skip() {
        navigationManager.newRoot(Screen.BottomNavigationScreen.Main.route)
    }

}