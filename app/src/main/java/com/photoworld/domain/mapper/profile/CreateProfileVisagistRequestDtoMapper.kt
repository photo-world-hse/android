package com.photoworld.domain.mapper.profile

import com.photoworld.data.dto.profile.CreateProfileVisagistRequestDto
import com.photoworld.data.model.BaseCreateProfile
import javax.inject.Inject

class CreateProfileVisagistRequestDtoMapper @Inject constructor() {

    fun map(baseCreateProfile: BaseCreateProfile): CreateProfileVisagistRequestDto {
        return CreateProfileVisagistRequestDto(
            aboutMe = baseCreateProfile.aboutMe,
            workExperience = baseCreateProfile.workExperience,
            extraInfo = baseCreateProfile.extraInfo,
            avatarUrl = baseCreateProfile.avatarUrl,
            tags = baseCreateProfile.tags,
            photos = baseCreateProfile.photos,
            services = emptyList(),
        )
    }

}