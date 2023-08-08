package com.example.data.chats.list.repository

import com.example.data.chats.list.network.model.ChatJson
import com.example.data.chats.list.network.model.ChatNetwork
import com.example.data.chats.list.network.service.ChatListNetworkService
import com.example.domain.chats.list.ChatsListRepository
import com.example.domain.chats.list.model.ChatDomain
import io.github.jan.supabase.realtime.PostgresAction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single

class ChatsListRepositoryImpl (
    private val chatListNetworkService: ChatListNetworkService,
    private val userId: String
): ChatsListRepository {

    override fun getUserChats(): Flow<List<ChatDomain>> {
        val result = chatListNetworkService.getUserChats(userId)
        return result.map { listChat ->
            listChat.map { chat ->
                chat.toDomain()
            }
        }
    }

    override fun getUserChat(chatJson: Any): Flow<ChatDomain> {
        val result = chatListNetworkService.getUserChat(
            userId = userId,
            chatJson = chatJson as ChatJson
        )
        return result.map {
            it.toDomain()
        }
    }

    override suspend fun broadcastUserChats(): Flow<PostgresAction> {
        val result = chatListNetworkService.broadcastUserChats(userId)
        return result
    }
}