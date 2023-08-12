package com.example.faeture.chat.dialog.domain.use_cases

import com.example.faeture.chat.dialog.domain.ChatDialogRepository
import io.github.jan.supabase.realtime.PostgresAction
import kotlinx.coroutines.flow.Flow

class BroadcastChatMessagesUseCase(
    private val chatDialogRepository: ChatDialogRepository
) {

    suspend fun execute(chatId: String): Flow<PostgresAction> {
        val result = chatDialogRepository.broadcastChatMessages(chatId)
        return result
    }

}