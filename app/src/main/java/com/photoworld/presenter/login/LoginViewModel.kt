package com.photoworld.presenter.login

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.photoworld.domain.model.LoginInfo
import com.photoworld.domain.usecase.GetChatInfoUseCase
import com.photoworld.domain.usecase.LoginUseCase
import com.photoworld.domain.model.login.LoginInfo
import com.photoworld.domain.usecase.login.LoginUseCase
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import com.photoworld.uitls.SendbirdUIKitInitializer
import com.sendbird.uikit.SendbirdUIKit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val loginUseCase: LoginUseCase,
    private val sendbirdUIKitInitializer: SendbirdUIKitInitializer,
    private val getChatInfoUseCase: GetChatInfoUseCase,
) : ViewModel() {

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
        viewModelScope.launch {
            try {
                val loginInfo = LoginInfo(
                    email = _emailState.value,
                    password = _passwordState.value,
                )
                if (loginUseCase(loginInfo)) {
                    val chatInfo = getChatInfoUseCase()
                    if (chatInfo != null) {
                        sendbirdUIKitInitializer.init(chatInfo)
                        SendbirdUIKit.connect { _, e ->
                            if (e != null) Log.e("SendbirdConnect", e.stackTraceToString())
                            openMainScreen()
                        }
                    } else {
                        openMainScreen()
                    }
                }
            } catch (error: Throwable) {
                println(error)
            }
        }
    }

    private fun openMainScreen() {
        navigationManager.newRoot(Screen.BottomNavigationScreen.Main.route)
    }
}
