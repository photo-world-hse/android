package com.photoworld.domain.usecase

import com.photoworld.data.repository.LoginRepository
import com.photoworld.domain.mapper.RegistrationRequestDtoMapper
import com.photoworld.domain.model.RegistrationInfo
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
    private val registrationRequestDtoMapper: RegistrationRequestDtoMapper,
) {

    suspend operator fun invoke(registrationInfo: RegistrationInfo) {
        val registrationRequestDto = registrationRequestDtoMapper.map(registrationInfo)
        loginRepository.register(registrationRequestDto)
    }

}