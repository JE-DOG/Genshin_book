package com.example.domain.chats.list.use_cases

import com.example.domain.chats.list.ChatsListRepository
import kotlinx.coroutines.flow.callbackFlow

class GetUserChatsUseCase (
    private val chatsListRepository: ChatsListRepository
) {

    fun execute(userId: String) = callbackFlow{

        val result = chatsListRepository.getUserChats(
            userId = userId
        )
        send(result)

        close()
    }

}