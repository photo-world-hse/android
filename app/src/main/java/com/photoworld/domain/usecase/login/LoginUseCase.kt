package com.photoworld.domain.usecase.login

import com.photoworld.data.repository.LoginRepository
import com.photoworld.domain.mapper.login.LoginRequestDtoMapper
import com.photoworld.domain.model.login.LoginInfo
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
    private val loginRequestDtoMapper: LoginRequestDtoMapper,
    private val isLoginUseCase: IsLoginUseCase,
) {

    suspend operator fun invoke(loginInfo: LoginInfo): Boolean {
        val loginRequestDto = loginRequestDtoMapper.map(loginInfo)
        val token = loginRepository.login(loginRequestDto).sessionToken ?: ""
        if (token.isNotBlank()) {
            loginRepository.saveToken(token)
        }
        return isLoginUseCase()
    }

}