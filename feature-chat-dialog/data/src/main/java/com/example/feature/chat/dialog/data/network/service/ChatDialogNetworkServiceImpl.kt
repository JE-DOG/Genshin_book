package com.example.feature.chat.dialog.data.network.service

import com.example.data.chats.list.network.model.ChatJson
import com.example.data.core.supabase.Schema
import com.example.data.core.supabase.Tables
import com.example.feature.add.chat.data.network.model.ProfileJson
import com.example.feature.chat.dialog.data.network.model.MessageJson
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.FilterOperator
import io.github.jan.supabase.postgrest.query.Order
import io.github.jan.supabase.realtime.PostgresAction
import io.github.jan.supabase.realtime.createChannel
import io.github.jan.supabase.realtime.postgresChangeFlow
import io.github.jan.supabase.realtime.realtime
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class ChatDialogNetworkServiceImpl(
    private val supabaseClient: SupabaseClient,
    private val userId: String
): ChatDialogNetworkService {

    override fun getProfileByChatId(chatId: String): Flow<ProfileJson> = callbackFlow {
        val chat = supabaseClient.postgrest[Tables.CHATS.tableName].select {
            eq(Tables.CHATS.id,chatId)
        }
            .decodeList<ChatJson>()[0]
        val result = supabaseClient.postgrest[Tables.PROFILES.tableName].select {
            eq(
                Tables.PROFILES.id,
                if (userId == chat.first_user_id)
                    chat.second_user_id
                else
                    chat.first_user_id
            )
        }
            .decodeList<ProfileJson>()[0]

        send(result)

        close()
    }

    override fun getChatMessages(chatId: String): Flow<List<MessageJson>> = callbackFlow {

        val result = supabaseClient.postgrest[Tables.MESSAGES.tableName].select {
            eq(
                column = Tables.MESSAGES.chat_id,
                chatId
            )
        }
            .decodeList<MessageJson>()

        println(result)

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
//            filter = "${Tables.MESSAGES.chat_id}=$chatId"
        }

        channel.join()

        return broadcastFlow

    }
}