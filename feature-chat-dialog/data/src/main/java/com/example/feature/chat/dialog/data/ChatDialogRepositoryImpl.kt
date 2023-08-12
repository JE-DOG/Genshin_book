package com.example.feature.chat.dialog.data

import com.example.add.chat.domain.model.ProfileDomain
import com.example.faeture.chat.dialog.domain.ChatDialogRepository
import com.example.faeture.chat.dialog.domain.model.MessageDomain
import com.example.feature.chat.dialog.data.network.model.MessageJson
import com.example.feature.chat.dialog.data.network.service.ChatDialogNetworkService
import io.github.jan.supabase.realtime.PostgresAction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest

class ChatDialogRepositoryImpl(
    private val chatDialogNetworkService: ChatDialogNetworkService
): ChatDialogRepository {

    override fun getProfileByChatId(chatId: String): Flow<ProfileDomain> {
        val result = chatDialogNetworkService.getProfileByChatId(chatId)
            .map {
                it.toDomain()
            }
        return result
    }

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