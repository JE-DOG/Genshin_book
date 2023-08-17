package com.example.feature.chat.dialog.di.modules

import com.example.feature.chat.dialog.domain.ChatDialogRepository
import com.example.feature.chat.dialog.data.ChatDialogRepositoryImpl
import com.example.feature.chat.dialog.data.network.service.ChatDialogNetworkService
import com.example.feature.chat.dialog.data.network.service.ChatDialogNetworkServiceImpl
import dagger.Module
import dagger.Provides
import io.github.jan.supabase.SupabaseClient

@Module
class DataModule {

    @Provides
    fun provideChatDialogNetworkService(
        supabaseClient: SupabaseClient,
        userId: String
    ): ChatDialogNetworkService {
        return ChatDialogNetworkServiceImpl(
            supabaseClient,
            userId
        )
    }

    @Provides
    fun provideChatDialogRepository(
        chatDialogNetworkService: ChatDialogNetworkService
    ):ChatDialogRepository{
        return ChatDialogRepositoryImpl(
            chatDialogNetworkService
        )
    }

}