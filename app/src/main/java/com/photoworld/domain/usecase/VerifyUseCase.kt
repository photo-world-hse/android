package com.photoworld.domain.usecase

import com.photoworld.data.repository.LoginRepository
import com.photoworld.domain.mapper.VerifyRequestDtoMapper
import com.photoworld.domain.model.VerifyInfo
import javax.inject.Inject

class VerifyUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
    private val verifyRequestDtoMapper: VerifyRequestDtoMapper,
    private val isLoginUseCase: IsLoginUseCase,
) {

    suspend operator fun invoke(verifyInfo: VerifyInfo): Boolean {
        val verifyRequestDto = verifyRequestDtoMapper.map(verifyInfo)
        val authData = loginRepository.verify(verifyRequestDto)
        loginRepository.saveAuthData(authData)
        return isLoginUseCase()
    }

}