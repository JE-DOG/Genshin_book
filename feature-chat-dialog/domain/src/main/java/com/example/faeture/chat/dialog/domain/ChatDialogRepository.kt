package com.example.faeture.chat.dialog.domain

import com.example.faeture.chat.dialog.domain.model.MessageDomain
import io.github.jan.supabase.realtime.PostgresAction
import kotlinx.coroutines.flow.Flow

interface ChatDialogRepository {

    fun getChatMessages(chatId: String): Flow<List<MessageDomain>>

    suspend fun sendMessage(message: MessageDomain)

    suspend fun broadcastChatMessages(chatId: String): Flow<PostgresAction>

}