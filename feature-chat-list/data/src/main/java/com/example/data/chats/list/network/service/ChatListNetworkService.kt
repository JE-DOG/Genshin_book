package com.example.data.chats.list.network.service

import com.example.data.chats.list.network.model.ChatJson
import com.example.data.chats.list.network.model.ChatNetwork
import com.example.domain.chats.list.model.ChatDomain
import io.github.jan.supabase.realtime.PostgresAction
import kotlinx.coroutines.flow.Flow

interface ChatListNetworkService {

    fun getUserChats(userId: String): Flow<List<ChatNetwork>>

    fun getUserChat(userId: String,chatJson: ChatJson): Flow<ChatNetwork>

    suspend fun broadcastUserChats(userId: String): Flow<PostgresAction>

}