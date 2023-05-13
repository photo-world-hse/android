package com.photoworld.domain.model

data class VerifyInfo(
    val email: String,
    val activationCode: String,
)