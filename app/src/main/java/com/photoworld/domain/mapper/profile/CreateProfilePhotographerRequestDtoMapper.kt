package com.photoworld.domain.mapper.profile

import com.photoworld.data.dto.profile.CreateProfilePhotographerRequestDto
import com.photoworld.data.model.BaseCreateProfile
import javax.inject.Inject

class CreateProfilePhotographerRequestDtoMapper @Inject constructor() {

    fun map(baseCreateProfile: BaseCreateProfile): CreateProfilePhotographerRequestDto {
        return CreateProfilePhotographerRequestDto(
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