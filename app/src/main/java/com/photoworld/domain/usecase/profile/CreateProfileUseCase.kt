package com.photoworld.domain.usecase.profile

import com.photoworld.data.model.ModelCreateProfile
import com.photoworld.data.model.ProfileType
import com.photoworld.data.repository.ProfileRepository
import com.photoworld.domain.mapper.profile.CreateProfileModelRequestDtoMapper
import com.photoworld.domain.mapper.profile.CreateProfilePhotographerRequestDtoMapper
import com.photoworld.domain.mapper.profile.CreateProfileVisagistRequestDtoMapper
import javax.inject.Inject

class CreateProfileUseCase @Inject constructor(
    private val profileRepository: ProfileRepository,
    private val createProfilePhotographerRequestDtoMapper: CreateProfilePhotographerRequestDtoMapper,
    private val createProfileModelRequestDtoMapper: CreateProfileModelRequestDtoMapper,
    private val createProfileVisagistRequestDtoMapper: CreateProfileVisagistRequestDtoMapper,
) {

    suspend operator fun invoke(profileType: ProfileType) {
        val profile = profileRepository.getCreateProfile()
        profile?.let {
            when (profileType) {
                ProfileType.PHOTOGRAPHER -> {
                    val createProfilePhotographerRequestDto =
                        createProfilePhotographerRequestDtoMapper.map(profile)
                    profileRepository.createProfilePhotographer(createProfilePhotographerRequestDto)
                }
                ProfileType.MODEL -> {
                    if (profile is ModelCreateProfile) {
                        val createProfileModelRequestDto =
                            createProfileModelRequestDtoMapper.map(profile)
                        profileRepository.createProfileModel(createProfileModelRequestDto)
                    }
                }
                ProfileType.VISAGIST -> {
                    val createProfileVisagistRequestDto =
                        createProfileVisagistRequestDtoMapper.map(profile)
                    profileRepository.createProfileVisagist(createProfileVisagistRequestDto)
                }
            }
        }
    }

}