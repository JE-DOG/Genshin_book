package com.example.feature.chat.dialog.data.network.service

import com.example.feature.add.chat.data.network.model.ProfileJson
import com.example.feature.chat.dialog.data.network.model.MessageJson
import io.github.jan.supabase.realtime.PostgresAction
import kotlinx.coroutines.flow.Flow

interface ChatDialogNetworkService {

    fun getProfileByChatId(chatId: String): Flow<ProfileJson>

    fun getChatMessages(chatId: String): Flow<List<MessageJson>>

    suspend fun sendMessage(message: MessageJson)

    suspend fun broadcastChatMessages(chatId: String): Flow<PostgresAction>

}