package com.example.feature.chat.dialog.di.modules

import com.example.faeture.chat.dialog.domain.ChatDialogRepository
import com.example.faeture.chat.dialog.domain.use_cases.BroadcastChatMessagesUseCase
import com.example.faeture.chat.dialog.domain.use_cases.GetChatMessagesUseCase
import com.example.faeture.chat.dialog.domain.use_cases.GetProfileByChatIdUseCase
import com.example.faeture.chat.dialog.domain.use_cases.SendMessageUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideBroadcastChatMessagesUseCase(
        chatDialogRepository: ChatDialogRepository
    ):BroadcastChatMessagesUseCase{
        return BroadcastChatMessagesUseCase(
            chatDialogRepository
        )
    }

    @Provides
    fun provideGetProfileByIdUseCase(
        chatDialogRepository: ChatDialogRepository
    ): GetProfileByChatIdUseCase {
        return GetProfileByChatIdUseCase(
            chatDialogRepository
        )
    }

    @Provides
    fun provideGetChatMessagesUseCase(
        chatDialogRepository: ChatDialogRepository
    ): GetChatMessagesUseCase {
        return GetChatMessagesUseCase(
            chatDialogRepository
        )
    }

    @Provides
    fun provideSendMessageUseCase(
        chatDialogRepository: ChatDialogRepository
    ):SendMessageUseCase{
        return SendMessageUseCase(
            chatDialogRepository
        )
    }

}