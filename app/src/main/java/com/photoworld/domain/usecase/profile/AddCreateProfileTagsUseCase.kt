package com.photoworld.domain.usecase.profile

import com.photoworld.data.repository.ProfileRepository
import javax.inject.Inject

class AddCreateProfileTagsUseCase @Inject constructor(
    private val profileRepository: ProfileRepository,
) {

    operator fun invoke(tags: List<String>) {
        profileRepository.addCreateProfileTags(tags)
    }

}