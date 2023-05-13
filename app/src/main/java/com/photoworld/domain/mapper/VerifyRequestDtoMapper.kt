package com.photoworld.domain.mapper

import com.photoworld.data.dto.verify.VerifyRequestDto
import com.photoworld.domain.model.VerifyInfo
import javax.inject.Inject

class VerifyRequestDtoMapper @Inject constructor() {

    fun map(verifyInfo: VerifyInfo): VerifyRequestDto {
        return VerifyRequestDto(
            email = verifyInfo.email,
            activationCode = verifyInfo.activationCode,
        )
    }

}