package com.example.feature.chats.list.di.modules

import com.example.domain.chats.list.ChatsListRepository
import com.example.domain.chats.list.use_cases.BroadcastUserChatsUseCase
import com.example.domain.chats.list.use_cases.GetUserChatUseCase
import com.example.domain.chats.list.use_cases.GetUserChatsUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainChatsListModule {

    @Provides
    fun provideBroadcastUserChatsUseCase(
        chatsListRepository: ChatsListRepository
    ): BroadcastUserChatsUseCase {
        return BroadcastUserChatsUseCase(chatsListRepository)
    }

    @Provides
    fun provideGetUserChatsUseCase(
        chatsListRepository: ChatsListRepository
    ): GetUserChatsUseCase {
        return GetUserChatsUseCase(
            chatsListRepository = chatsListRepository
        )
    }

    @Provides
    fun provideGetUserChatUseCase(
        chatsListRepository: ChatsListRepository
    ): GetUserChatUseCase {
        return GetUserChatUseCase(
            chatsListRepository = chatsListRepository
        )
    }



}