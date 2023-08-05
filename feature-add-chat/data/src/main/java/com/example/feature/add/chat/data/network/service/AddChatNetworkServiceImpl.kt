package com.example.feature.add.chat.data.network.service

import com.example.data.chats.list.network.model.ChatJson
import com.example.data.core.supabase.Tables
import com.example.feature.add.chat.data.network.model.ProfileJson
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.TextSearchType
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class AddChatNetworkServiceImpl(
    private val supabaseClient: SupabaseClient,
    private val userId: String
): AddChatNetworkService {

    override suspend fun addChat(userId: String): ChatJson {
        val result = coroutineScope {

            return@coroutineScope async {

                val hasChatWithThisUser = async {
                    supabaseClient.postgrest[Tables.CHATS.tableName].select {
                        or {

                            and {
                                eq(
                                    Tables.CHATS.first_user_id,
                                    userId
                                )

                                eq(
                                    Tables.CHATS.second_user_id,
                                    this@AddChatNetworkServiceImpl.userId
                                )

                            }

                            and {
                                eq(
                                    Tables.CHATS.second_user_id,
                                    userId
                                )

                                eq(
                                    Tables.CHATS.first_user_id,
                                    this@AddChatNetworkServiceImpl.userId
                                )

                            }


                        }
                    }.decodeList<ChatJson>()
                }

                if (hasChatWithThisUser.await().isEmpty()){
                    supabaseClient.postgrest[Tables.CHATS.tableName].insert(
                        ChatJson(
                            first_user_id = this@AddChatNetworkServiceImpl.userId,
                            second_user_id = userId
                        )
                    ).decodeAs<ChatJson>()
                }else {
                    hasChatWithThisUser.await()[0]
                }
            }
        }

        return result.await()
    }

    override fun findUser(userNick: String): Flow<List<ProfileJson>> = callbackFlow {

        val result = async {
            supabaseClient.postgrest[Tables.PROFILES.tableName].select {
                textSearch(
                    column = Tables.PROFILES.fullName,
                    query = "'$userNick'",
                    textSearchType = TextSearchType.PHRASETO
                )
            }.decodeList<ProfileJson>()

        }

        send(result.await())
        close()

    }
}