package com.example.domain.chats.list

import com.example.domain.chats.list.model.ChatDomain
import io.github.jan.supabase.realtime.PostgresAction
import kotlinx.coroutines.flow.Flow

interface ChatsListRepository {

    fun getUserChats(userId: String): Flow<List<ChatDomain>>

    fun getUserChat(chatId: String,userId: String): Flow<ChatDomain>

    suspend fun broadcastUserChats(userId: String): Flow<PostgresAction>

}