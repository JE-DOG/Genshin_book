package com.example.data.chats.list.network.service

import com.example.data.chats.list.network.model.ChatNetwork
import kotlinx.coroutines.flow.Flow

interface ChatListNetworkService {

    suspend fun getUserChats(userId: String): Flow<List<ChatNetwork>>

}