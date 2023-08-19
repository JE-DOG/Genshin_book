package com.example.domain.chats.list.use_cases

import com.example.domain.chats.list.ChatsListRepository
import com.example.domain.chats.list.model.ChatDomain
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.single

class GetUserChatUseCase(
    private val chatsListRepository: ChatsListRepository
) {

    fun execute(chatJson: Any) = callbackFlow{

        val result = chatsListRepository.getUserChat(chatJson).single()
        send(result)

        close()
    }

}