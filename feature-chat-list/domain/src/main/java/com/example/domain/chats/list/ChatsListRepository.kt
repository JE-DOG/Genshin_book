package com.example.domain.chats.list

import com.example.domain.chats.list.model.ChatDomain
import io.github.jan.supabase.realtime.PostgresAction
import kotlinx.coroutines.flow.Flow

interface ChatsListRepository {

    fun getUserChats(): Flow<List<ChatDomain>>

    fun getUserChat(chatJson: Any): Flow<ChatDomain>

    suspend fun broadcastUserChats(): Flow<PostgresAction>

}