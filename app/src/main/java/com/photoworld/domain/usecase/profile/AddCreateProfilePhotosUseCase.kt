package com.photoworld.domain.usecase.profile

import com.photoworld.data.repository.ProfileRepository
import javax.inject.Inject

class AddCreateProfilePhotosUseCase @Inject constructor(
    private val profileRepository: ProfileRepository,
) {

    operator fun invoke(photos: List<String>) {
        profileRepository.addCreateProfilePhotos(photos)
    }

}