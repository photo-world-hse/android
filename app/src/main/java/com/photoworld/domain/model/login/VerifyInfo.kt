package com.photoworld.domain.model.login

data class VerifyInfo(
    val email: String,
    val activationCode: String,
)