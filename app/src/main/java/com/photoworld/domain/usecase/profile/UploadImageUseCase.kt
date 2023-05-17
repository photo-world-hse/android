package com.photoworld.domain.usecase.profile

import com.photoworld.data.repository.ProfileRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class UploadImageUseCase @Inject constructor(
    private val profileRepository: ProfileRepository,
) {

    suspend operator fun invoke(file: MultipartBody.Part): String {
        val uploadImageResponseDto = profileRepository.uploadImage(file)
        return uploadImageResponseDto.imageUrl ?: ""
    }

}