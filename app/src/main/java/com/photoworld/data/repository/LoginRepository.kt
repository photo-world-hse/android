package com.photoworld.data.repository

import androidx.annotation.CheckResult
import com.photoworld.data.dto.login.AuthDataDto
import com.photoworld.data.dto.login.LoginRequestDto
import com.photoworld.data.dto.login.RegistrationRequestDto
import com.photoworld.data.dto.login.TokenDto
import com.photoworld.data.dto.login.VerifyRequestDto
import com.photoworld.data.dto.registration.RegistrationRequestDto
import com.photoworld.data.dto.verify.VerifyRequestDto
import com.photoworld.data.retrofit.ClientAPI
import com.photoworld.data.sharedpreferences.SharedPreferencesController
import com.photoworld.data.sharedpreferences.SharedPreferencesKey
import com.photoworld.domain.model.ChatInfo
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val clientAPI: ClientAPI,
    private val sharedPreferencesController: SharedPreferencesController,
) {

    @CheckResult
    suspend fun login(
        loginRequestDto: LoginRequestDto,
    ): AuthDataDto {
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
    ): AuthDataDto {
        return clientAPI.verify(verifyRequestDto)
    }

    fun saveAuthData(authData: AuthDataDto) {
        val bearerToken = "Bearer ${authData.sessionToken}"
        val chatInfo = ChatInfo(
            appId = authData.chatAppId,
            userId = authData.chatUserId,
            accessToken = authData.chatAccessToken,
            username = authData.username,
        )
        with(sharedPreferencesController) {
            put(SharedPreferencesKey.BEARER_TOKEN, bearerToken)
            put(SharedPreferencesKey.CHAT_INFO, chatInfo)
        }
    }

    fun getToken(): String? {
        return sharedPreferencesController.get(SharedPreferencesKey.BEARER_TOKEN)
    }

    fun getChatInfo(): ChatInfo? = sharedPreferencesController.get(SharedPreferencesKey.CHAT_INFO)

    fun deleteAuthData() {
        with(sharedPreferencesController) {
            delete(SharedPreferencesKey.BEARER_TOKEN)
            delete(SharedPreferencesKey.CHAT_INFO)
        }
    }
}
