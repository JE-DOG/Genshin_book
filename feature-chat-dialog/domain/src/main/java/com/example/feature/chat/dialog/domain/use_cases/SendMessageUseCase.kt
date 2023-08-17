package com.example.feature.chat.dialog.domain.use_cases

import com.example.feature.chat.dialog.domain.ChatDialogRepository
import com.example.feature.chat.dialog.domain.model.MessageDomain

class SendMessageUseCase(
    private val chatDialogRepository: ChatDialogRepository
) {

    suspend fun execute(messageDomain: MessageDomain){
        chatDialogRepository.sendMessage(messageDomain)
    }

}