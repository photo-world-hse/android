package com.photoworld.data.dto.verify

import com.google.gson.annotations.SerializedName

data class VerifyRequestDto(
    @SerializedName("email")
    val email: String,
    @SerializedName("activation_code")
    val activationCode: String,
)
