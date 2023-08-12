package com.example.data.chats.list.network.service

import com.example.data.chats.list.network.model.ChatJson
import com.example.data.chats.list.network.model.ChatNetwork
import com.example.data.chats.list.network.model.MessageJson
import com.example.data.chats.list.network.model.ProfileJson
import com.example.data.core.supabase.Schema
import com.example.data.core.supabase.Tables
import com.example.domain.chats.list.model.ChatDomain
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
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

class ChatListNetworkServiceImpl(
    private val supabaseClient: SupabaseClient
): ChatListNetworkService {

    override fun getUserChats(userId: String): Flow<List<ChatNetwork>> = callbackFlow {

        val userChats = supabaseClient.postgrest[Tables.CHATS.tableName].select {
            or {
                eq(Tables.CHATS.first_user_id,userId)
                eq(Tables.CHATS.second_user_id,userId)
            }

        }.decodeList<ChatJson>()

        println(userChats)

        val result = userChats.map { chat ->
            getUserChat(userId,chat).single()
        }

        send(result)

        close()
    }

    override fun getUserChat(userId: String, chat: ChatJson): Flow<ChatNetwork> = callbackFlow {

        val chatId = chat.id

        val lastMessage = async {
            supabaseClient.postgrest[Tables.MESSAGES.tableName].select {
                eq(Tables.MESSAGES.chat_id, chatId)
                order(
                    Tables.MESSAGES.message,
                    order = Order.DESCENDING
                )
                limit(1)
            }.decodeList<MessageJson>()
        }

        val user = async {
            supabaseClient.postgrest[Tables.PROFILES.tableName].select {
                eq(
                    Tables.PROFILES.id,
                    if ( userId == chat.first_user_id )
                        chat.second_user_id
                    else
                        chat.first_user_id
                )
                limit(1)
            }.decodeList<ProfileJson>()
        }

        println(user.await())

        val result = try {

            ChatNetwork(
                id = chat.id,
                first_user_id = chat.first_user_id,
                second_user_id = chat.second_user_id,
                created_at = chat.created_at,
                lastMessage = lastMessage.await()[0].message,
                fullName = user.await()[0].fullname,
                avatar = user.await()[0].avatar
            )

        }catch (e: Exception){

            ChatNetwork(
                id = chat.id,
                first_user_id = chat.first_user_id,
                second_user_id = chat.second_user_id,
                created_at = chat.created_at,
                lastMessage = null,
                fullName = user.await()[0].fullname,
                avatar = user.await()[0].avatar
            )

        }


        send(result)

        close()
    }

    override suspend fun broadcastUserChats(userId: String): Flow<PostgresAction> {

        val realtime = supabaseClient.realtime

        realtime.connect()

        val channel = realtime.createChannel(Tables.CHATS.tableName)

        val broadcastFlow = channel.postgresChangeFlow<PostgresAction>(schema = Schema.PUBLIC.schema){
            table = Tables.CHATS.tableName
        }

        channel.join()

        return broadcastFlow
    }
}
