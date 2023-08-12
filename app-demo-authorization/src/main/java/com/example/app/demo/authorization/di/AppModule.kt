package com.example.app.demo.authorization.di

import android.content.Context
import android.content.SharedPreferences
import com.example.app.demo.authorization.App
import com.example.core.keys.SharedPreferencesKeys
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideSharedPreferences(
        context: Context
    ): SharedPreferences {
        return context.getSharedPreferences(App.SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE)
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