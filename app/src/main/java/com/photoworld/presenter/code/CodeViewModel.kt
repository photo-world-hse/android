package com.photoworld.presenter.code

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.photoworld.domain.model.VerifyInfo
import com.photoworld.domain.usecase.VerifyUseCase
import com.photoworld.presenter.navigation.NavigationManager
import com.photoworld.presenter.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CodeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val navigationManager: NavigationManager,
    private val verifyUseCase: VerifyUseCase,
) : ViewModel() {

    private val _emailState = mutableStateOf(
        value = savedStateHandle[Screen.Code.EMAIL_ARGUMENT] ?: ""
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
                    navigationManager.newRoot(Screen.CreateProfileStart.route)
                }
            } catch (error: Throwable) {
                println(error)
            }
        }
    }

}