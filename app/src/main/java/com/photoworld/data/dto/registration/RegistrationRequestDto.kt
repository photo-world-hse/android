package com.photoworld.data.dto.registration

import com.google.gson.annotations.SerializedName

data class RegistrationRequestDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
)
