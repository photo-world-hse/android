package com.photoworld.data.datastore

import com.photoworld.data.model.BaseCreateProfile
import com.photoworld.data.model.ModelCreateProfile
import com.photoworld.data.model.ProfileType
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CreateProfileDataStore @Inject constructor() {

    private val lock = Any()
    private var profile: BaseCreateProfile? = null

    fun setupProfile(profileType: ProfileType) {
        synchronized(lock) {
            profile = if (profileType == ProfileType.MODEL) {
                ModelCreateProfile()
            } else {
                BaseCreateProfile()
            }
        }
    }

    fun addTags(tags: List<String>) {
        synchronized(lock) {
            profile?.tags = tags
        }
    }

    fun addAboutInfo(
        aboutMe: String,
        workExperience: Double,
    ) {
        synchronized(lock) {
            profile?.aboutMe = aboutMe
            profile?.workExperience = workExperience
        }
    }

    fun addPhotos(photos: List<String>) {
        synchronized(lock) {
            profile?.photos = photos
        }
    }

    fun addAvatarUrl(avatarUrl: String) {
        synchronized(lock) {
            profile?.avatarUrl = avatarUrl
        }
    }

    fun getCreateProfile(): BaseCreateProfile? {
        return synchronized(lock) {
            profile
        }
    }

}