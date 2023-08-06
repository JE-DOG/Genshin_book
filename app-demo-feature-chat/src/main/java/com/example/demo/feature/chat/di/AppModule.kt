package com.example.demo.feature.chat.di

import com.example.core.app.navigation.ScreenProvider
import com.example.demo.feature.chat.presentation.navigation.ScreenProviderImpl
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import dagger.Module
import dagger.Provides
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.realtime.Realtime
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideSupabaseClient(): SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = "https://ykjjabiybawaxcaxcuua.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InlramphYml5YmF3YXhjYXhjdXVhIiwicm9sZSI6ImFub24iLCJpYXQiOjE2ODg2NTIwMDMsImV4cCI6MjAwNDIyODAwM30.e7QiZZHHaVyNEQQoFj3hNd11A29MqIF3jr2FTU8Mvmc"
        ){
            install(Postgrest)
            install(Realtime)
        }
    }

    @Provides
    fun provideUserId(): String {
        return "0c2274b8-a827-4905-af84-efabe3d53525"
    }

    private val cicerone = Cicerone.create()

    @Provides
    fun provideRouter(): Router {
        return cicerone.router
    }

    @Provides
    fun provideNavigatorHolder(): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }

    @Provides
    fun provideScreenProvider(): ScreenProvider {
        return ScreenProviderImpl()
    }

}