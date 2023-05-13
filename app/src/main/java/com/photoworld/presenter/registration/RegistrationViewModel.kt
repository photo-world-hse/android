package com.photoworld.presenter.registration

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.photoworld.R
import com.photoworld.domain.model.RegistrationInfo
import com.photoworld.domain.usecase.RegisterUseCase
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import com.photoworld.presenter.state.TextFieldState
import com.photoworld.presenter.state.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val registerUseCase: RegisterUseCase,
) : ViewModel() {

    private val _nameState = mutableStateOf("")
    val nameState: State<String> = _nameState

    private val _emailState = mutableStateOf("")
    val emailState: State<String> = _emailState

    private val _passwordState = mutableStateOf(TextFieldState())
    val passwordState: State<TextFieldState> = _passwordState

    private val _repeatPasswordState = mutableStateOf(TextFieldState())
    val repeatPasswordState: State<TextFieldState> = _repeatPasswordState

    fun onNameChange(newValue: String) {
        _nameState.value = newValue
    }

    fun onEmailChange(newValue: String) {
        _emailState.value = newValue
    }

    fun onPasswordChange(newValue: String) {
        _passwordState.value = TextFieldState(text = newValue)
    }

    fun onRepeatPasswordChange(newValue: String) {
        _repeatPasswordState.value = TextFieldState(text = newValue)
    }

    fun createAccount() {
        if (_passwordState.value.text != _repeatPasswordState.value.text) {
            _repeatPasswordState.value = _repeatPasswordState.value.copy(
                error = UiText.StringResource(R.string.not_same_passwords_error)
            )
        } else {
            viewModelScope.launch {
                try {
                    val registrationInfo = RegistrationInfo(
                        name = _nameState.value,
                        email = _emailState.value,
                        password = _passwordState.value.text,
                    )
                    registerUseCase(registrationInfo)
                    navigationManager.navigate(Screen.Code(email = _emailState.value).route)
                } catch (error: Throwable) {
                    println(error)
                }
            }
        }
    }
}