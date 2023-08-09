package com.example.feature.chat.dialog.data.network.service

import com.example.faeture.chat.dialog.domain.model.MessageDomain
import com.example.feature.chat.dialog.data.network.model.MessageJson
import io.github.jan.supabase.realtime.PostgresAction
import kotlinx.coroutines.flow.Flow

interface ChatDialogNetworkService {

    fun getChatMessages(chatId: String): Flow<List<MessageJson>>

    suspend fun sendMessage(message: MessageJson)

    suspend fun broadcastChatMessages(chatId: String): Flow<PostgresAction>

}