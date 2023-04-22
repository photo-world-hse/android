package com.photoworld.presenter.code

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CodeViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
) : ViewModel() {

    private val _emailState = mutableStateOf("mishafk15@mail.ru")
    val emailState: State<String> = _emailState

    private val _codeState = mutableStateOf("")
    val codeState: State<String> = _codeState

    fun onCodeChange(newValue: String) {
        _codeState.value = newValue
    }

    fun login() {
        navigationManager.newRoot(Screen.BottomNavigationScreen.Main.route)
    }

}