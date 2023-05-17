package com.photoworld.domain.usecase.profile

import com.photoworld.data.model.ProfileType
import com.photoworld.data.repository.ProfileRepository
import javax.inject.Inject

class SetupProfileUseCase @Inject constructor(
    private val profileRepository: ProfileRepository,
) {

    operator fun invoke(profileType: ProfileType) {
        profileRepository.setupProfile(profileType)
    }

}