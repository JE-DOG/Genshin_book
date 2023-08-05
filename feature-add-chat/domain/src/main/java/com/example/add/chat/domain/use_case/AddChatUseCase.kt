package com.example.add.chat.domain.use_case

import com.example.add.chat.domain.AddChatRepository

class AddChatUseCase(
    private val addChatRepository: AddChatRepository
) {

    fun execute(userId: String): Boolean{
        val result = addChatRepository.addChat(userId)
        return result
    }

}