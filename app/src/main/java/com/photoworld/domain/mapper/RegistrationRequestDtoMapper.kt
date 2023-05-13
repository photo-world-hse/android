package com.photoworld.domain.mapper

import com.photoworld.data.dto.registration.RegistrationRequestDto
import com.photoworld.domain.model.RegistrationInfo
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