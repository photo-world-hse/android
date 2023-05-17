package com.photoworld.uitls

import android.util.Log
import com.photoworld.domain.model.ChatInfo
import com.sendbird.android.exception.SendbirdException
import com.sendbird.android.handler.InitResultHandler
import com.sendbird.uikit.adapter.SendbirdUIKitAdapter
import com.sendbird.uikit.interfaces.UserInfo

class SendbirdAdapter(private val chatInfo: ChatInfo) : SendbirdUIKitAdapter {

    override fun getAppId(): String = chatInfo.appId

    override fun getAccessToken(): String = chatInfo.accessToken

    override fun getUserInfo(): UserInfo =
        ChatUserInfo(
            userId = chatInfo.userId,
            nickname = chatInfo.username,
        )

    override fun getInitResultHandler(): InitResultHandler = object : InitResultHandler {
        override fun onInitFailed(e: SendbirdException) {
            Log.e("SendbirdInit", e.stackTraceToString())
        }

        override fun onInitSucceed() {
            Log.d("SendbirdInit", "Sendbird successfully init")
        }

        override fun onMigrationStarted() {}
    }

    private data class ChatUserInfo(
        @JvmField
        val userId: String?,
        @JvmField
        val nickname: String?,
    ) : UserInfo {
        override fun getUserId(): String = userId.orEmpty()

        override fun getNickname(): String? = nickname

        override fun getProfileUrl(): String? = null
    }
}
