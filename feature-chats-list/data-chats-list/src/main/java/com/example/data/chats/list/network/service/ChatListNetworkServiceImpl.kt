package com.example.data.chats.list.network.service

import com.example.data.chats.list.network.model.ChatJson
import com.example.data.chats.list.network.model.ChatNetwork
import com.example.data.chats.list.network.model.MessageJson
import com.example.data.chats.list.network.model.ProfileJson
import com.example.data.core.supabase.Schema
import com.example.data.core.supabase.Tables
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Order
import io.github.jan.supabase.postgrest.query.PostgrestBuilder
import io.github.jan.supabase.postgrest.query.PostgrestFilterBuilder
import io.github.jan.supabase.realtime.PostgresAction
import io.github.jan.supabase.realtime.Realtime
import io.github.jan.supabase.realtime.createChannel
import io.github.jan.supabase.realtime.postgresChangeFlow
import io.github.jan.supabase.realtime.realtime
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

class ChatListNetworkServiceImpl(
    private val supabaseClient: SupabaseClient
): ChatListNetworkService {

    override fun getUserChats(userId: String): Flow<List<ChatNetwork>> = callbackFlow {

        val userChats = supabaseClient.postgrest["chats"].select {
            or {
                eq("first_user_id",userId)
                eq("second_user_id",userId)
            }

        }.decodeList<ChatJson>()

        val result = userChats.map { chat ->

            val lastMessage = async {
                supabaseClient.postgrest[Tables.MESSAGES.tableName].select {
                    eq(Tables.MESSAGES.chat_id, chat.id)
                    order(Tables.MESSAGES.message, Order.DESCENDING)
                    limit(1)
                }.decodeAs<MessageJson>()
            }

            val user = async {
                supabaseClient.postgrest[Tables.PROFILES.tableName].select {
                    eq(
                        Tables.PROFILES.id,
                        if ( userId == chat.first_user_id )
                            chat.second_user_id
                        else
                            userId
                    )
                }.decodeAs<ProfileJson>()
            }



            ChatNetwork(
                id = chat.id,
                first_user_id = chat.first_user_id,
                second_user_id = chat.second_user_id,
                created_at = chat.created_at,
                lastMessage = lastMessage.await().message,
                fullName = user.await().fullname,
                avatar = user.await().avatar
            )
        }

        send(result)

        close()
    }

    override suspend fun broadcastUserChats(userId: String): Flow<PostgresAction> {

        val realtime = supabaseClient.realtime

        supabaseClient.realtime.connect()

        val channel = realtime.createChannel(Tables.MESSAGES.tableName)

        val broadcastFlow = channel.postgresChangeFlow<PostgresAction>(schema = Schema.PUBLIC.schema){
            table = Tables.CHATS.tableName
        }

        channel.join()

        return broadcastFlow
    }
}
