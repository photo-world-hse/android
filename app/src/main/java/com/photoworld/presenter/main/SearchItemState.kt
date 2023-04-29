package com.photoworld.presenter.main

import androidx.compose.runtime.Immutable

@Immutable
data class SearchItemState(
    val avatarUrl: String,
    val name: String,
    val photoUrls: List<String>,
)
