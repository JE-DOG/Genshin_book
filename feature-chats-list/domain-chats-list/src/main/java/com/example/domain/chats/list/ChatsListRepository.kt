package com.example.domain.chats.list

import com.example.domain.chats.list.model.ChatDomain
import kotlinx.coroutines.flow.Flow

interface ChatsListRepository {

    fun getUserChats(userId: String): Flow<List<ChatDomain>>

}