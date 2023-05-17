package com.photoworld.data.retrofit

import com.photoworld.data.dto.login.AuthDataDto
import com.photoworld.data.dto.login.LoginRequestDto
import com.photoworld.data.dto.login.RegistrationRequestDto
import com.photoworld.data.dto.login.TokenDto
import com.photoworld.data.dto.login.VerifyRequestDto
import com.photoworld.data.dto.profile.CreateProfileModelRequestDto
import com.photoworld.data.dto.profile.CreateProfilePhotographerRequestDto
import com.photoworld.data.dto.profile.CreateProfileVisagistRequestDto
import com.photoworld.data.dto.profile.ProfilesResponseDto
import com.photoworld.data.dto.profile.TagsResponseDto
import com.photoworld.data.dto.profile.UploadImageResponseDto
import okhttp3.MultipartBody
import com.photoworld.data.dto.registration.RegistrationRequestDto
import com.photoworld.data.dto.verify.VerifyRequestDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface ClientAPI {

    @POST("auth/authenticate")
    suspend fun login(
        @Body
        loginRequestDto: LoginRequestDto,
    ): AuthDataDto

    @POST("auth/register")
    suspend fun register(
        @Body
        registrationRequestDto: RegistrationRequestDto,
    )

    @POST("auth/verify")
    suspend fun verify(
        @Body
        verifyRequestDto: VerifyRequestDto,
    ): AuthDataDto

    @GET("profiles")
    suspend fun getProfiles(
        @Header("Authorization")
        authorizationToken: String,
    ): ProfilesResponseDto

    @GET("profiles/{profile_name}/tags")
    suspend fun getTags(
        @Header("Authorization")
        authorizationToken: String,
        @Path("profile_name")
        profileName: String,
    ): TagsResponseDto

    @Multipart
    @POST("images/upload")
    suspend fun uploadImage(
        @Header("Authorization")
        authorizationToken: String,
        @Part
        file: MultipartBody.Part,
    ): UploadImageResponseDto

    @PUT("profiles/photographer")
    suspend fun createProfilePhotographer(
        @Header("Authorization")
        authorizationToken: String,
        @Body
        createProfilePhotographerRequestDto: CreateProfilePhotographerRequestDto,
    )

    @PUT("profiles/model")
    suspend fun createProfileModel(
        @Header("Authorization")
        authorizationToken: String,
        @Body
        createProfileModelRequestDto: CreateProfileModelRequestDto,
    )

    @PUT("profiles/visagist")
    suspend fun createProfileVisagist(
        @Header("Authorization")
        authorizationToken: String,
        @Body
        createProfileVisagistRequestDto: CreateProfileVisagistRequestDto,
    )

}