package com.example.data.chats.list.network.service

import com.example.data.chats.list.network.model.ChatJson
import com.example.data.chats.list.network.model.ChatNetwork
import com.example.data.chats.list.network.model.MessageJson
import com.example.data.chats.list.network.model.ProfileJson
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Order
import io.github.jan.supabase.postgrest.query.PostgrestBuilder
import io.github.jan.supabase.postgrest.query.PostgrestFilterBuilder
import io.github.jan.supabase.realtime.Realtime
import io.github.jan.supabase.realtime.realtime
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

class ChatListNetworkServiceImpl(
    private val supabaseClient: SupabaseClient
): ChatListNetworkService {

    override suspend fun getUserChats(userId: String): Flow<List<ChatNetwork>> = callbackFlow {

        val userChats = supabaseClient.postgrest["chats"].select {
            or {
                eq("first_user_id",userId)
                eq("second_user_id",userId)
            }

        }.decodeList<ChatJson>()

        val result = userChats.map { chat ->

            val lastMessage = supabaseClient.postgrest["messages"].select {
                eq("id_chat", chat.id)
                order("message", Order.DESCENDING)
                limit(1)
            }.decodeAs<MessageJson>()

            val user = supabaseClient.postgrest["profiles"].select {
                or {
                    neq("first_user_id",userId)
                    neq("second_user_id",userId)
                }
            }.decodeAs<ProfileJson>()


            ChatNetwork(
                id = chat.id,
                first_user_id = chat.first_user_id,
                second_user_id = chat.second_user_id,
                created_at = chat.created_at,
                lastMessage = lastMessage.message,
                fullName = user.fullname,
                avatar = user.avatar
            )
        }

        send(result)

        close()
    }

}
