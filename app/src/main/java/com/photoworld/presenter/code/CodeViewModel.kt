package com.photoworld.presenter.code

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.photoworld.domain.model.VerifyInfo
import com.photoworld.domain.usecase.GetChatInfoUseCase
import com.photoworld.domain.usecase.VerifyUseCase
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import com.photoworld.uitls.SendbirdUIKitInitializer
import com.sendbird.uikit.SendbirdUIKit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CodeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val navigationManager: NavigationManager,
    private val verifyUseCase: VerifyUseCase,
    private val getChatInfoUseCase: GetChatInfoUseCase,
    private val sendbirdUIKitInitializer: SendbirdUIKitInitializer,
) : ViewModel() {

    private val _emailState = mutableStateOf(
        value = savedStateHandle[Screen.Code.EMAIL_ARGUMENT] ?: "",
    )
    val emailState: State<String> = _emailState

    private val _codeState = mutableStateOf("")
    val codeState: State<String> = _codeState

    fun onCodeChange(newValue: String) {
        _codeState.value = newValue
    }

    fun verify() {
        viewModelScope.launch {
            try {
                val verifyInfo = VerifyInfo(
                    email = _emailState.value,
                    activationCode = _codeState.value,
                )
                if (verifyUseCase(verifyInfo)) {
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
