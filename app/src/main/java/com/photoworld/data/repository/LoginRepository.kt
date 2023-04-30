package com.photoworld.data.repository

import androidx.annotation.CheckResult
import com.photoworld.data.dto.login.LoginRequestDto
import com.photoworld.data.dto.login.LoginResponseDto
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
    ): LoginResponseDto {
        return clientAPI.login(loginRequestDto)
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