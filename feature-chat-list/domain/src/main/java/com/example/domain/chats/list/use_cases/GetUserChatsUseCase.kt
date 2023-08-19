package com.example.domain.chats.list.use_cases

import com.example.domain.chats.list.ChatsListRepository
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.single

class GetUserChatsUseCase (
    private val chatsListRepository: ChatsListRepository
) {

    fun execute() = callbackFlow{

        val result = chatsListRepository.getUserChats().single()
        send(result)

        close()
    }

}