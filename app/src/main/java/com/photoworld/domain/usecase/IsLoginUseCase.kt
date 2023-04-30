package com.photoworld.domain.usecase

import com.photoworld.data.repository.LoginRepository
import javax.inject.Inject

class IsLoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
) {

    operator fun invoke(): Boolean {
        return loginRepository.getToken().isNotBlank()
    }

}