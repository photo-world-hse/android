package com.photoworld.data.retrofit

import com.photoworld.data.dto.login.LoginRequestDto
import com.photoworld.data.dto.login.LoginResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface ClientAPI {

    @POST("auth/authenticate")
    suspend fun login(
        @Body
        authorizationRequestDto: LoginRequestDto,
    ): LoginResponseDto

}