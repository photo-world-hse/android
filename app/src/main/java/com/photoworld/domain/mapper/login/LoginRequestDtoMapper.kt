package com.photoworld.domain.mapper.login

import com.photoworld.data.dto.login.LoginRequestDto
import com.photoworld.domain.model.login.LoginInfo
import javax.inject.Inject

class LoginRequestDtoMapper @Inject constructor() {

    fun map(loginInfo: LoginInfo): LoginRequestDto {
        return LoginRequestDto(
            email = loginInfo.email,
            password = loginInfo.password,
        )
    }

}