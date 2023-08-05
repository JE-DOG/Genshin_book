package com.example.add.chat.domain

import com.example.add.chat.domain.model.ProfileDomain
import kotlinx.coroutines.flow.Flow

interface AddChatRepository {

    fun addChat( userId: String ): Boolean

    fun findUser(userNick: String): Flow<List<ProfileDomain>>

}