package com.example.genshinbook.di

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.core.app.navigation.ScreenProvider
import com.example.core.keys.SharedPreferencesKeys
import com.example.genshinbook.App
import com.example.genshinbook.presentation.navigation.ScreenProviderImpl
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.realtime.Realtime

@Module
class AppModule {

    @Provides
    @AppScope
    fun provideScreenProvider(): ScreenProvider {
        return ScreenProviderImpl()
    }

    @Provides
    @AppScope
    fun provideSharedPreferences(
        context: Context
    ): SharedPreferences {
        return context.getSharedPreferences(App.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    @Provides
    @AppScope
    fun provideSupabaseClient(): SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = "https://ykjjabiybawaxcaxcuua.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InlramphYml5YmF3YXhjYXhjdXVhIiwicm9sZSI6ImFub24iLCJpYXQiOjE2ODg2NTIwMDMsImV4cCI6MjAwNDIyODAwM30.e7QiZZHHaVyNEQQoFj3hNd11A29MqIF3jr2FTU8Mvmc"
        ){
            install(Postgrest)
            install(GoTrue)
            install(Realtime)
        }
    }

    @Provides
    fun provideUserId(
        sharedPreferences: SharedPreferences
    ): String {
        val result = sharedPreferences.getString(SharedPreferencesKeys.USER_ID_KEY,"")
        return result!!
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

}