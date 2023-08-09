package com.example.feature.chat.dialog.data

import com.example.faeture.chat.dialog.domain.ChatDialogRepository
import com.example.faeture.chat.dialog.domain.model.MessageDomain
import com.example.feature.chat.dialog.data.network.model.MessageJson
import com.example.feature.chat.dialog.data.network.service.ChatDialogNetworkService
import io.github.jan.supabase.realtime.PostgresAction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChatDialogRepositoryImpl(
    private val chatDialogNetworkService: ChatDialogNetworkService
): ChatDialogRepository {

    override fun getChatMessages(chatId: String): Flow<List<MessageDomain>> {
        val result = chatDialogNetworkService.getChatMessages(chatId)
            .map {  list ->
                list.map { messageJson ->
                 messageJson.toDomain()
              }
        }
        return result
    }

    override suspend fun sendMessage(message: MessageDomain) {
        chatDialogNetworkService.sendMessage(MessageJson.fromDomain(message))
    }

    override suspend fun broadcastChatMessages(chatId: String): Flow<PostgresAction> {
        val result = chatDialogNetworkService.broadcastChatMessages(chatId)
        return result
    }
}