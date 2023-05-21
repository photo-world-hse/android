package com.photoworld.data.datastore

import com.photoworld.data.model.ProfileType
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FiltersDataStore @Inject constructor() {

    private val lock = Any()
    private var profileType: ProfileType? = null

    fun setProfileType(profileType: ProfileType?) {
        synchronized(lock) {
            this.profileType = profileType
        }
    }

    fun getProfileType(): ProfileType? {
        return synchronized(lock) {
            profileType
        }
    }

}