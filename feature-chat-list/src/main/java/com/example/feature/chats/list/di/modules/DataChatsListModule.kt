package com.example.feature.chats.list.di.modules

import com.example.core.app.di.UserIdQualifier
import com.example.data.chats.list.network.service.ChatListNetworkService
import com.example.data.chats.list.network.service.ChatListNetworkServiceImpl
import com.example.data.chats.list.repository.ChatsListRepositoryImpl
import com.example.domain.chats.list.ChatsListRepository
import dagger.Module
import dagger.Provides
import io.github.jan.supabase.SupabaseClient

@Module
class DataChatsListModule {

    @Provides
    fun provideNetworkService(
        supabaseClient: SupabaseClient
    ): ChatListNetworkService{
        return ChatListNetworkServiceImpl(supabaseClient)
    }

    @Provides
    fun provideChatsListRepository(
        chatListNetworkService: ChatListNetworkService,
        userId: String
    ): ChatsListRepository {
        return ChatsListRepositoryImpl(
            chatListNetworkService = chatListNetworkService,
            userId = userId
        )
    }

}