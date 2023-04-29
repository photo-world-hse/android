package com.photoworld.presenter.createprofile.tag

import androidx.compose.runtime.Immutable

@Immutable
data class CreateProfileTagState(
    val text: String,
    var isSelected: Boolean = false,
)
