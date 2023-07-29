package com.example.data.chats.list.repository

import com.example.data.chats.list.network.service.ChatListNetworkService
import com.example.domain.chats.list.ChatsListRepository
import com.example.domain.chats.list.model.ChatDomain
import io.github.jan.supabase.realtime.PostgresAction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChatsListRepositoryImpl(
    private val chatListNetworkService: ChatListNetworkService
): ChatsListRepository {

    override fun getUserChats(userId: String): Flow<List<ChatDomain>> {
        val result = chatListNetworkService.getUserChats(userId)
        return result.map {
            it.map {
                it.toDomain()
            }
        }
    }

    override fun getUserChat(chatId: String, userId: String): Flow<ChatDomain> {
        val result = chatListNetworkService.getUserChat(
            userId = userId,
            chatId = chatId
        )
        return result.map {
            it.toDomain()
        }
    }

    override suspend fun broadcastUserChats(userId: String): Flow<PostgresAction> {
        val result = chatListNetworkService.broadcastUserChats(userId)
        return result
    }
}