package com.example.feature.chat.dialog.data.network.service

import com.example.data.core.supabase.Schema
import com.example.data.core.supabase.Tables
import com.example.feature.chat.dialog.data.network.model.MessageJson
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.FilterOperator
import io.github.jan.supabase.realtime.PostgresAction
import io.github.jan.supabase.realtime.createChannel
import io.github.jan.supabase.realtime.postgresChangeFlow
import io.github.jan.supabase.realtime.realtime
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class ChatDialogNetworkServiceImpl(
    private val supabaseClient: SupabaseClient,
): ChatDialogNetworkService {

    override fun getChatMessages(chatId: String): Flow<List<MessageJson>> = callbackFlow {

        val result = supabaseClient.postgrest[Tables.MESSAGES.tableName].select {
            filter(
                column = Tables.CHATS.id,
                operator = FilterOperator.LIKE,
                chatId
            )
        }.decodeList<MessageJson>()

        send(result)

        close()
    }

    override suspend fun sendMessage(message: MessageJson) {
        supabaseClient.postgrest[Tables.MESSAGES.tableName].insert(message)
    }

    override suspend fun broadcastChatMessages(chatId: String): Flow<PostgresAction> {

        val realtime = supabaseClient.realtime

        val channel = realtime.createChannel(Tables.MESSAGES.tableName)

        val broadcastFlow = channel.postgresChangeFlow<PostgresAction>(schema = Schema.PUBLIC.schema){
            table = Tables.MESSAGES.tableName
            filter = "${Tables.CHATS.id}=eq.$chatId"
        }

        channel.join()

        return broadcastFlow

    }
}