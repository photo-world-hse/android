package com.photoworld.uitls

import android.content.Context
import com.photoworld.domain.model.ChatInfo
import com.sendbird.uikit.SendbirdUIKit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SendbirdUIKitInitializer @Inject constructor(
    @ApplicationContext
    private val context: Context,
) {

    fun init(chatInfo: ChatInfo) {
        val sendbirdAdapter = SendbirdAdapter(chatInfo)
        SendbirdUIKit.init(sendbirdAdapter, context)
    }
}