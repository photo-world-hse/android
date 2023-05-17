package com.photoworld.data.dto.login

import com.google.gson.annotations.SerializedName

data class TokenDto(
    @SerializedName("session_token")
    val sessionToken: String?,
    @SerializedName("chat_access_token")
    val chatAccessToken: String?,
    @SerializedName("chat_user_id")
    val chatUserId: String?,
    @SerializedName("chat_app_id")
    val chatAppId: String?,
    @SerializedName("username")
    val username: String?,
)
