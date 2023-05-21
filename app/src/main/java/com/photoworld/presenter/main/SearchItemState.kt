package com.photoworld.presenter.main

import androidx.compose.runtime.Immutable
import com.photoworld.data.model.ProfileType

@Immutable
data class SearchItemState(
    val avatarUrl: String,
    val name: String,
    val photoUrls: List<String>,
    val profileType: ProfileType,
)
