package com.photoworld.presenter

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.photoworld.domain.usecase.IsLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val isLoginUseCase: IsLoginUseCase,
) : ViewModel() {

    private val _isLoginState = mutableStateOf(isLoginUseCase())
    val isLoginState: State<Boolean> = _isLoginState

}