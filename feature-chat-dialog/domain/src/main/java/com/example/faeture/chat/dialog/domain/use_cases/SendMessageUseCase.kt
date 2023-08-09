package com.example.faeture.chat.dialog.domain.use_cases

import com.example.faeture.chat.dialog.domain.ChatDialogRepository
import com.example.faeture.chat.dialog.domain.model.MessageDomain

class SendMessageUseCase(
    private val chatDialogRepository: ChatDialogRepository
) {

    suspend fun execute(messageDomain: MessageDomain){
        chatDialogRepository.sendMessage(messageDomain)
    }

}