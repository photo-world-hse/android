package com.photoworld.data.dto.profile

import com.google.gson.annotations.SerializedName

data class CreateProfileVisagistRequestDto(
    @SerializedName("about_me")
    val aboutMe: String,
    @SerializedName("work_experience")
    val workExperience: Double,
    @SerializedName("extra_info")
    val extraInfo: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("services")
    val services: List<String>,
    @SerializedName("photos")
    val photos: List<String>,
)
