package com.photoworld.presenter.state

import androidx.compose.runtime.Immutable

@Immutable
data class TextFieldState(
    val text: String = "",
    val error: UiText = UiText.DynamicString(""),
)
