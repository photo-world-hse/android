package com.photoworld.data.retrofit

import com.photoworld.data.dto.login.LoginRequestDto
import com.photoworld.data.dto.login.TokenDto
import com.photoworld.data.dto.registration.RegistrationRequestDto
import com.photoworld.data.dto.verify.VerifyRequestDto
import retrofit2.http.Body
import retrofit2.http.POST

interface ClientAPI {

    @POST("auth/authenticate")
    suspend fun login(
        @Body
        loginRequestDto: LoginRequestDto,
    ): TokenDto

    @POST("auth/register")
    suspend fun register(
        @Body
        registrationRequestDto: RegistrationRequestDto,
    )

    @POST("auth/verify")
    suspend fun verify(
        @Body
        verifyRequestDto: VerifyRequestDto,
    ): TokenDto

}