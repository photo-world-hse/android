package com.photoworld.data.dto.profile

import com.google.gson.annotations.SerializedName

data class ProfileShortInfoDto(
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("avatar_url")
    val avatarUrl: String,
)
