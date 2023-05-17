package com.photoworld.data.dto.profile

import com.google.gson.annotations.SerializedName

data class ProfilesResponseDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("profiles")
    val profiles: Map<String, ProfileShortInfoDto>,
)
