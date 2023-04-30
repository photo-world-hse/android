package com.photoworld.domain.mapper

import com.photoworld.data.dto.login.LoginRequestDto
import com.photoworld.domain.model.LoginInfo
import javax.inject.Inject

class LoginRequestDtoMapper @Inject constructor() {

    fun map(loginInfo: LoginInfo): LoginRequestDto {
        return LoginRequestDto(
            email = loginInfo.email,
            password = loginInfo.password,
        )
    }

}