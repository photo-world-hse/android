package com.photoworld.domain.mapper.profile

import com.photoworld.data.dto.profile.CreateProfileModelRequestDto
import com.photoworld.data.model.ModelCreateProfile
import javax.inject.Inject

class CreateProfileModelRequestDtoMapper @Inject constructor() {

    fun map(modelCreateProfile: ModelCreateProfile): CreateProfileModelRequestDto {
        return CreateProfileModelRequestDto(
            aboutMe = modelCreateProfile.aboutMe,
            workExperience = modelCreateProfile.workExperience,
            extraInfo = modelCreateProfile.extraInfo,
            avatarUrl = modelCreateProfile.avatarUrl,
            tags = modelCreateProfile.tags,
            photos = modelCreateProfile.photos,
            services = emptyList(),
            height = modelCreateProfile.height,
            hipGirth = modelCreateProfile.hipGirth,
            bust = modelCreateProfile.bust,
            waistCircumference = modelCreateProfile.waistCircumference,
            hairColor = modelCreateProfile.hairColor,
            eyeColor = modelCreateProfile.eyeColor,
        )
    }

}