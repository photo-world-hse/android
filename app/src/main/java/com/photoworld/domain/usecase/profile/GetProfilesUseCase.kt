package com.photoworld.domain.usecase.profile

import com.photoworld.data.repository.ProfileRepository
import com.photoworld.domain.mapper.profile.ProfilesInfoMapper
import com.photoworld.domain.model.profile.ProfilesInfo
import javax.inject.Inject

class GetProfilesUseCase @Inject constructor(
    private val profileRepository: ProfileRepository,
    private val profilesInfoMapper: ProfilesInfoMapper,
) {

    suspend operator fun invoke(): ProfilesInfo {
        val profilesResponseDto = profileRepository.getProfiles()
        return profilesInfoMapper.map(profilesResponseDto)
    }

}