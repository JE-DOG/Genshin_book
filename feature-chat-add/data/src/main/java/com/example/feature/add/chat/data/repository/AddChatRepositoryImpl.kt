package com.example.feature.add.chat.data.repository

import com.example.add.chat.domain.AddChatRepository
import com.example.add.chat.domain.model.ProfileDomain
import com.example.feature.add.chat.data.network.service.AddChatNetworkService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AddChatRepositoryImpl(
    private val addChatNetworkService: AddChatNetworkService
): AddChatRepository {

    override suspend fun addChat(userId: String): Any {
        val result = addChatNetworkService.addChat(userId)
        return result
    }

    override fun findUser(userNick: String): Flow<List<Any>> {
        val result = addChatNetworkService.findUser(userNick)
        return result
    }
}