package com.example.data.chats.list.network.service

import com.example.data.chats.list.network.model.ChatNetwork
import io.github.jan.supabase.realtime.PostgresAction
import kotlinx.coroutines.flow.Flow

interface ChatListNetworkService {

    fun getUserChats(userId: String): Flow<List<ChatNetwork>>

    suspend fun broadcastUserChats(userId: String): Flow<PostgresAction>

}