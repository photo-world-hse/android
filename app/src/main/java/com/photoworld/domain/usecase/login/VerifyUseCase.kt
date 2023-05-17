package com.photoworld.domain.usecase.login

import com.photoworld.data.repository.LoginRepository
import com.photoworld.domain.mapper.login.VerifyRequestDtoMapper
import com.photoworld.domain.model.login.VerifyInfo
import javax.inject.Inject

class VerifyUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
    private val verifyRequestDtoMapper: VerifyRequestDtoMapper,
    private val isLoginUseCase: IsLoginUseCase,
) {

    suspend operator fun invoke(verifyInfo: VerifyInfo): Boolean {
        val verifyRequestDto = verifyRequestDtoMapper.map(verifyInfo)
        val token = loginRepository.verify(verifyRequestDto).sessionToken ?: ""
        if (token.isNotBlank()) {
            loginRepository.saveToken(token)
        }
        val authData = loginRepository.verify(verifyRequestDto)
        loginRepository.saveAuthData(authData)
        return isLoginUseCase()
    }

}