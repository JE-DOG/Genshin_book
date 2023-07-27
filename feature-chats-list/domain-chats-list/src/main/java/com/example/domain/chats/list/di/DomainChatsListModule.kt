package com.example.domain.chats.list.di

import com.example.domain.chats.list.ChatsListRepository
import com.example.domain.chats.list.use_cases.GetUserChatsUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainChatsListModule {

    @Provides
    fun provideGetUserChatsUseCase(
        chatsListRepository: ChatsListRepository
    ): GetUserChatsUseCase {
        return GetUserChatsUseCase(
            chatsListRepository = chatsListRepository
        )
    }

}