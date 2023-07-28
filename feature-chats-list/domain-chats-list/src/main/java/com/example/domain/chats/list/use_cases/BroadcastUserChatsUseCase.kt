package com.example.domain.chats.list.use_cases

import com.example.domain.chats.list.ChatsListRepository
import com.example.domain.chats.list.model.ChatDomain
import kotlinx.coroutines.flow.Flow

class BroadcastUserChatsUseCase(
    private val chatsListRepository: ChatsListRepository
) {

    fun execute(userId: String): Flow<ChatDomain> {
        val result = chatsListRepository.broadcastUserChats(userId)
        return result
    }

}