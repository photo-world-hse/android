package com.photoworld.domain.usecase

import com.photoworld.data.repository.LoginRepository
import com.photoworld.domain.mapper.LoginRequestDtoMapper
import com.photoworld.domain.model.LoginInfo
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
    private val loginRequestDtoMapper: LoginRequestDtoMapper,
    private val isLoginUseCase: IsLoginUseCase,
) {

    suspend operator fun invoke(loginInfo: LoginInfo): Boolean {
        val loginRequestDto = loginRequestDtoMapper.map(loginInfo)
        val authData = loginRepository.login(loginRequestDto)
        loginRepository.saveAuthData(authData)
        return isLoginUseCase()
    }
}
