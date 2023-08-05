package com.example.add.chat.domain

import com.example.add.chat.domain.model.ProfileDomain
import kotlinx.coroutines.flow.Flow

interface AddChatRepository {

    suspend fun addChat(userId: String): Any //ChatJson

    fun findUser(userNick: String): Flow<List<ProfileDomain>>

}