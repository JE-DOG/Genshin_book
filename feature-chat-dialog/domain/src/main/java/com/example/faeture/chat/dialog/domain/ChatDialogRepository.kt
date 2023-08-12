package com.example.faeture.chat.dialog.domain

import com.example.add.chat.domain.model.ProfileDomain
import com.example.faeture.chat.dialog.domain.model.MessageDomain
import io.github.jan.supabase.realtime.PostgresAction
import kotlinx.coroutines.flow.Flow

interface ChatDialogRepository {

    fun getChatMessages(chatId: String): Flow<List<MessageDomain>>

    fun getProfileByChatId(chatId: String): Flow<ProfileDomain>

    suspend fun sendMessage(message: MessageDomain)

    suspend fun broadcastChatMessages(chatId: String): Flow<PostgresAction>

}