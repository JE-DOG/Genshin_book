package com.example.add.chat.domain.use_case

import com.example.add.chat.domain.AddChatRepository

class AddChatUseCase(
    private val addChatRepository: AddChatRepository
) {

    suspend fun execute(userId: String): Any { //return ChatJson
        val result = addChatRepository.addChat(userId)
        return result
    }

}