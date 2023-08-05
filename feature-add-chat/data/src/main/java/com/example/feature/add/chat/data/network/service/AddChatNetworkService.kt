package com.example.feature.add.chat.data.network.service

import com.example.data.chats.list.network.model.ChatJson
import com.example.feature.add.chat.data.network.model.ProfileJson
import kotlinx.coroutines.flow.Flow

interface AddChatNetworkService {

    suspend fun addChat(userId: String): ChatJson

    fun findUser(userNick: String): Flow<List<ProfileJson>>

}