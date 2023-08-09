package com.example.faeture.chat.dialog.domain.use_cases

import com.example.faeture.chat.dialog.domain.ChatDialogRepository
import com.example.faeture.chat.dialog.domain.model.MessageDomain
import kotlinx.coroutines.flow.Flow

class GetChatMessagesUseCase(
    private val chatDialogRepository: ChatDialogRepository
) {

    fun execute(chatId: String): Flow<List<MessageDomain>> {
        val result = chatDialogRepository.getChatMessages(chatId)
        return result
    }

}