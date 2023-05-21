package com.photoworld.data.datastore

import com.photoworld.data.model.ProfileType
import com.photoworld.presenter.main.SearchItemState
import com.photoworld.presenter.photosessions.PhotoSessionState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FiltersDataStore @Inject constructor() {

    private val lock = Any()
    private var profileType: ProfileType? = null
    private var isAdd: Boolean = false
    private var users: MutableList<SearchItemState> = mutableListOf()
    private var feedback: SearchItemState? = null
    private var userName: String = "Кузнецов Михаил"
    private var chatUser: SearchItemState? = null
    private var photoSessions: MutableList<PhotoSessionState> = mutableListOf()

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

    fun setAdd(isAdd: Boolean) {
        synchronized(lock) {
            this.isAdd = isAdd
        }
    }

    fun isAdd(): Boolean {
        return synchronized(lock) {
            isAdd
        }
    }

    fun addUser(searchItemState: SearchItemState) {
        synchronized(lock) {
            users.add(searchItemState)
        }
    }

    fun getUsers(): MutableList<SearchItemState> {
        return synchronized(lock) {
            users
        }
    }

    fun setFeedback(feedback: SearchItemState) {
        synchronized(lock) {
            this.feedback = feedback
        }
    }

    fun getFeedback(): SearchItemState? {
        return synchronized(lock) {
            feedback
        }
    }

    fun setUserName(userName: String) {
        synchronized(lock) {
            this.userName = userName
        }
    }

    fun getUserName(): String {
        return synchronized(lock) {
            userName
        }
    }

    fun setChatUser(chatUser: SearchItemState) {
        synchronized(lock) {
            this.chatUser = chatUser
        }
    }

    fun getChatUser(): SearchItemState? {
        return synchronized(lock) {
            chatUser
        }
    }

    fun setPhotoSessions(photoSessions: MutableList<PhotoSessionState>) {
        synchronized(lock) {
            this.photoSessions = photoSessions
        }
    }

    fun getPhotoSessions(): MutableList<PhotoSessionState> {
        return synchronized(lock) {
            photoSessions
        }
    }

}