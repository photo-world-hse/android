package com.photoworld.domain.usecase.profile

import com.photoworld.data.repository.ProfileRepository
import javax.inject.Inject

class AddCreateProfileAvatarUrlUseCase @Inject constructor(
    private val profileRepository: ProfileRepository,
) {

    operator fun invoke(avatarUrl: String) {
        profileRepository.addCreateProfileAvatarUrl(avatarUrl = avatarUrl)
    }

}