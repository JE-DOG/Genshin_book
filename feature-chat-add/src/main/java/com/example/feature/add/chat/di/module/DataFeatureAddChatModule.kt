package com.example.feature.add.chat.di.module

import com.example.add.chat.domain.AddChatRepository
import com.example.feature.add.chat.data.network.service.AddChatNetworkService
import com.example.feature.add.chat.data.network.service.AddChatNetworkServiceImpl
import com.example.feature.add.chat.data.repository.AddChatRepositoryImpl
import dagger.Module
import dagger.Provides
import io.github.jan.supabase.SupabaseClient

@Module
class DataFeatureAddChatModule {

    @Provides
    fun provideAddChatNetworkService(
        supabaseClient: SupabaseClient,
        userId: String
    ): AddChatNetworkService {
        return AddChatNetworkServiceImpl(
            supabaseClient = supabaseClient,
            userId = userId
        )
    }

    @Provides
    fun provideAddChatRepository(
        addChatNetworkService: AddChatNetworkService
    ): AddChatRepository {
        return AddChatRepositoryImpl(addChatNetworkService)
    }

}