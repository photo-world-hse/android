package com.photoworld.domain.usecase.profile

import com.photoworld.data.repository.ProfileRepository
import javax.inject.Inject

class AddCreateProfileAboutInfoUseCase @Inject constructor(
    private val profileRepository: ProfileRepository,
) {

    operator fun invoke(
        aboutMe: String,
        workExperience: Double,
    ) {
        profileRepository.addCreateProfileAboutInfo(
            aboutMe = aboutMe,
            workExperience = workExperience,
        )
    }

}