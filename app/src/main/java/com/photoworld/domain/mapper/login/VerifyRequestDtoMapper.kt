package com.photoworld.domain.mapper.login

import com.photoworld.data.dto.login.VerifyRequestDto
import com.photoworld.domain.model.login.VerifyInfo
import javax.inject.Inject

class VerifyRequestDtoMapper @Inject constructor() {

    fun map(verifyInfo: VerifyInfo): VerifyRequestDto {
        return VerifyRequestDto(
            email = verifyInfo.email,
            activationCode = verifyInfo.activationCode,
        )
    }

}