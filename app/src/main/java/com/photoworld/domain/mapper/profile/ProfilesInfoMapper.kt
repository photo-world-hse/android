package com.photoworld.domain.mapper.profile

import com.photoworld.data.dto.profile.ProfilesResponseDto
import com.photoworld.domain.model.profile.ProfilesInfo
import javax.inject.Inject

class ProfilesInfoMapper @Inject constructor(
    private val profileTypeMapper: ProfileTypeMapper,
) {

    fun map(profilesResponseDto: ProfilesResponseDto): ProfilesInfo {
        val profiles = profilesResponseDto.profiles.map { (profileTypeString, profileInfo) ->
            val profileType = profileTypeMapper.map(profileTypeString)
            profileType to profileInfo.avatarUrl
        }.toMap()
        return ProfilesInfo(
            name = profilesResponseDto.name,
            profiles = profiles,
        )
    }

}