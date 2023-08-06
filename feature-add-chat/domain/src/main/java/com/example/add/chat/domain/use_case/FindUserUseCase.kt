package com.example.add.chat.domain.use_case

import com.example.add.chat.domain.AddChatRepository
import com.example.add.chat.domain.model.ProfileDomain
import kotlinx.coroutines.flow.Flow

class FindUserUseCase(
    private val addChatRepository: AddChatRepository
) {

    fun execute(userNick: String): Flow<List<Any>> {
        val result = addChatRepository.findUser(userNick = userNick)
        return result
    }

}