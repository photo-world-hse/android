package com.photoworld.presenter.profile

import androidx.compose.runtime.Immutable

@Immutable
data class ProfileSubScreensState(
    val isPhotoSubScreenSelected: Boolean = false,
    val isInfoSubScreenSelected: Boolean = false,
)
