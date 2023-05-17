package com.photoworld.data.model

class ModelCreateProfile(
    aboutMe: String = "",
    workExperience: Double = 0.0,
    extraInfo: String = "",
    avatarUrl: String = "",
    tags: List<String> = emptyList(),
    photos: List<String> = emptyList(),
    var height: Double = 0.0,
    var hipGirth: Double = 0.0,
    var bust: Double = 0.0,
    var waistCircumference: Double = 0.0,
    var hairColor: String = "",
    var eyeColor: String = "",
) : BaseCreateProfile(
    aboutMe = aboutMe,
    workExperience = workExperience,
    extraInfo = extraInfo,
    avatarUrl = avatarUrl,
    tags = tags,
    photos = photos,
)