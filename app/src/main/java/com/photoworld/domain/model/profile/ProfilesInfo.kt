package com.photoworld.domain.model.profile

import com.photoworld.data.model.ProfileType

data class ProfilesInfo(
    val name: String,
    val profiles: Map<ProfileType, String>,
)
