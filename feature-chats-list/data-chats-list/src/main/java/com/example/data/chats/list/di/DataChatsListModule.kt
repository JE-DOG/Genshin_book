package com.example.data.chats.list.di

import com.example.data.chats.list.network.service.ChatListNetworkService
import com.example.data.chats.list.network.service.ChatListNetworkServiceImpl
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

}