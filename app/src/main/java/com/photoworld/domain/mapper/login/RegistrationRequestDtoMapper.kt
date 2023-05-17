package com.photoworld.domain.mapper.login

import com.photoworld.data.dto.login.RegistrationRequestDto
import com.photoworld.domain.model.login.RegistrationInfo
import javax.inject.Inject

class RegistrationRequestDtoMapper @Inject constructor() {

    fun map(registrationInfo: RegistrationInfo): RegistrationRequestDto {
        return RegistrationRequestDto(
            name = registrationInfo.name,
            email = registrationInfo.email,
            password = registrationInfo.password,
        )
    }

}