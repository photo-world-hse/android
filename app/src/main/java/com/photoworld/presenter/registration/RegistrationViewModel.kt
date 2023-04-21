package com.photoworld.presenter.registration

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
) : ViewModel() {

    private val _nameState = mutableStateOf("")
    val nameState: State<String> = _nameState

    private val _emailState = mutableStateOf("")
    val emailState: State<String> = _emailState

    private val _passwordState = mutableStateOf("")
    val passwordState: State<String> = _passwordState

    private val _repeatPasswordState = mutableStateOf("")
    val repeatPasswordState: State<String> = _repeatPasswordState

    fun onNameChange(newValue: String) {
        _nameState.value = newValue
    }

    fun onEmailChange(newValue: String) {
        _emailState.value = newValue
    }

    fun onPasswordChange(newValue: String) {
        _passwordState.value = newValue
    }

    fun onRepeatPasswordChange(newValue: String) {
        _repeatPasswordState.value = newValue
    }

    fun createAccount() {
        navigationManager.navigate(Screen.Code.route)
    }

}