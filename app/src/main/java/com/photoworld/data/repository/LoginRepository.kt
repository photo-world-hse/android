package com.photoworld.data.repository

import androidx.annotation.CheckResult
import com.photoworld.data.dto.login.LoginRequestDto
import com.photoworld.data.dto.login.TokenDto
import com.photoworld.data.dto.registration.RegistrationRequestDto
import com.photoworld.data.dto.verify.VerifyRequestDto
import com.photoworld.data.retrofit.ClientAPI
import com.photoworld.data.sharedpreferences.SharedPreferencesController
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val clientAPI: ClientAPI,
    private val sharedPreferencesController: SharedPreferencesController,
) {

    @CheckResult
    suspend fun login(
        loginRequestDto: LoginRequestDto,
    ): TokenDto {
        return clientAPI.login(loginRequestDto)
    }

    @CheckResult
    suspend fun register(
        registrationRequestDto: RegistrationRequestDto,
    ) {
        return clientAPI.register(registrationRequestDto)
    }

    @CheckResult
    suspend fun verify(
        verifyRequestDto: VerifyRequestDto,
    ): TokenDto {
        return clientAPI.verify(verifyRequestDto)
    }

    fun saveToken(token: String) {
        val bearerToken = "Bearer $token"
        sharedPreferencesController.putToken(bearerToken)
    }

    fun getToken(): String {
        return sharedPreferencesController.getToken()
    }

    fun deleteToken() {
        sharedPreferencesController.deleteToken()
    }

}