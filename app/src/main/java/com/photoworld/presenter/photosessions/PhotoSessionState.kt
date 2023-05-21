package com.photoworld.presenter.photosessions

import androidx.compose.runtime.Immutable

@Immutable
data class PhotoSessionState(
    val name: String,
    val place: String,
    val time: String,
    val type: PhotoSessionType,
    val showDate: Boolean,
    val timeToTime: String,
    val day: String,
    val dayNumber: String,
)
