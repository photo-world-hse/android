package com.photoworld.presenter.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _emailState = mutableStateOf("")
    val emailState: State<String> = _emailState

    private val _passwordState = mutableStateOf("")
    val passwordState: State<String> = _passwordState

    fun onEmailChange(newValue: String) {
        _emailState.value = newValue
    }

    fun onPasswordChange(newValue: String) {
        _passwordState.value = newValue
    }

    fun login() {

    }

}