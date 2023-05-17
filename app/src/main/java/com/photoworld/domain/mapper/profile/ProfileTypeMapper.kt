package com.photoworld.domain.mapper.profile

import com.photoworld.data.model.ProfileType
import javax.inject.Inject

class ProfileTypeMapper @Inject constructor() {

    fun map(profileTypeString: String): ProfileType {
        return ProfileType.values().first { profileType -> profileType.value == profileTypeString }
    }

}