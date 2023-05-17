package com.photoworld.domain.usecase.profile

import com.photoworld.data.model.ProfileType
import com.photoworld.data.repository.ProfileRepository
import javax.inject.Inject

class GetTagsUseCase @Inject constructor(
    private val profileRepository: ProfileRepository,
) {

    suspend operator fun invoke(profileType: ProfileType): List<String> {
        val tagsResponseDto = profileRepository.getTags(profileType.value)
        return tagsResponseDto.tags
    }

}