package com.photoworld.domain.usecase

import com.photoworld.data.repository.LoginRepository
import com.photoworld.domain.model.ChatInfo
import javax.inject.Inject

class GetChatInfoUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
) {

    operator fun invoke(): ChatInfo? = loginRepository.getChatInfo()
}