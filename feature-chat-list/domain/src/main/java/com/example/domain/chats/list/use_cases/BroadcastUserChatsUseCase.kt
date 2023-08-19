package com.example.domain.chats.list.use_cases

import com.example.domain.chats.list.ChatsListRepository
import com.example.domain.chats.list.model.ChatDomain
import io.github.jan.supabase.realtime.PostgresAction
import kotlinx.coroutines.flow.Flow

class BroadcastUserChatsUseCase(
    private val chatsListRepository: ChatsListRepository
) {

    suspend fun execute(): Flow<PostgresAction> {
        val result = chatsListRepository.broadcastUserChats()
        return result
    }

}