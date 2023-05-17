package com.photoworld.data.repository

import com.photoworld.data.datastore.CreateProfileDataStore
import com.photoworld.data.dto.profile.CreateProfileModelRequestDto
import com.photoworld.data.dto.profile.CreateProfilePhotographerRequestDto
import com.photoworld.data.dto.profile.CreateProfileVisagistRequestDto
import com.photoworld.data.dto.profile.ProfilesResponseDto
import com.photoworld.data.dto.profile.TagsResponseDto
import com.photoworld.data.dto.profile.UploadImageResponseDto
import com.photoworld.data.model.BaseCreateProfile
import com.photoworld.data.model.ProfileType
import com.photoworld.data.retrofit.ClientAPI
import okhttp3.MultipartBody
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val clientAPI: ClientAPI,
    private val loginRepository: LoginRepository,
    private val createProfileDataStore: CreateProfileDataStore,
) {

    suspend fun getProfiles(): ProfilesResponseDto {
        val token = loginRepository.getToken()
        return clientAPI.getProfiles(token)
    }

    suspend fun getTags(profileName: String): TagsResponseDto {
        val token = loginRepository.getToken()
        return clientAPI.getTags(
            authorizationToken = token,
            profileName = profileName,
        )
    }

    fun setupProfile(profileType: ProfileType) {
        createProfileDataStore.setupProfile(profileType)
    }

    fun addCreateProfileTags(tags: List<String>) {
        createProfileDataStore.addTags(tags)
    }

    fun addCreateProfileAboutInfo(
        aboutMe: String,
        workExperience: Double,
    ) {
        createProfileDataStore.addAboutInfo(
            aboutMe = aboutMe,
            workExperience = workExperience,
        )
    }

    fun addCreateProfilePhotos(photos: List<String>) {
        createProfileDataStore.addPhotos(photos = photos)
    }

    fun addCreateProfileAvatarUrl(avatarUrl: String) {
        createProfileDataStore.addAvatarUrl(avatarUrl = avatarUrl)
    }

    suspend fun uploadImage(file: MultipartBody.Part): UploadImageResponseDto {
        val token = loginRepository.getToken()
        return clientAPI.uploadImage(
            authorizationToken = token,
            file = file,
        )
    }

    suspend fun createProfilePhotographer(
        createProfilePhotographerRequestDto: CreateProfilePhotographerRequestDto
    ) {
        val token = loginRepository.getToken()
        clientAPI.createProfilePhotographer(
            authorizationToken = token,
            createProfilePhotographerRequestDto = createProfilePhotographerRequestDto,
        )
    }

    suspend fun createProfileModel(
        createProfileModelRequestDto: CreateProfileModelRequestDto
    ) {
        val token = loginRepository.getToken()
        clientAPI.createProfileModel(
            authorizationToken = token,
            createProfileModelRequestDto = createProfileModelRequestDto,
        )
    }

    suspend fun createProfileVisagist(
        createProfileVisagistRequestDto: CreateProfileVisagistRequestDto
    ) {
        val token = loginRepository.getToken()
        clientAPI.createProfileVisagist(
            authorizationToken = token,
            createProfileVisagistRequestDto = createProfileVisagistRequestDto,
        )
    }

    fun getCreateProfile(): BaseCreateProfile? {
        return createProfileDataStore.getCreateProfile()
    }

}