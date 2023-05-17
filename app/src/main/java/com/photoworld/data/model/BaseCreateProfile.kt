package com.photoworld.data.model

open class BaseCreateProfile(
    var aboutMe: String = "",
    var workExperience: Double = 0.0,
    var extraInfo: String = "",
    var avatarUrl: String = "",
    var tags: List<String> = emptyList(),
    var photos: List<String> = emptyList(),
)
