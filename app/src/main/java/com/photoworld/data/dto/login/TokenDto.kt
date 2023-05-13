package com.photoworld.data.dto.login

import com.google.gson.annotations.SerializedName

data class TokenDto(
    @SerializedName("token")
    val token: String?,
    @SerializedName("tokenType")
    val tokenType: String?,
    @SerializedName("expired")
    val expired: Boolean?,
    @SerializedName("revoked")
    val revoked: Boolean?,
)
