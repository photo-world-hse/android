package com.photoworld.data.dto.profile

import com.google.gson.annotations.SerializedName

data class CreateProfileModelRequestDto(
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
    @SerializedName("height")
    val height: Double,
    @SerializedName("hip_girth")
    val hipGirth: Double,
    @SerializedName("bust")
    val bust: Double,
    @SerializedName("waist_circumference")
    val waistCircumference: Double,
    @SerializedName("hair_color")
    val hairColor: String,
    @SerializedName("eye_color")
    val eyeColor: String,
)
