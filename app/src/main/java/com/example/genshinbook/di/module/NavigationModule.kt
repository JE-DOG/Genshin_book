package com.example.genshinbook.di.module

import com.example.core.app.navigation.ScreenProvider
import com.example.genshinbook.di.AppScope
import com.example.genshinbook.presentation.navigation.ScreenProviderImpl
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides

@Module
class NavigationModule {

    @Provides
    @AppScope
    fun provideScreenProvider(): ScreenProvider {
        return ScreenProviderImpl()
    }

    private val cicerone = Cicerone.create()

    @Provides
    @AppScope
    fun provideRouter(): Router {
        return cicerone.router
    }

    @Provides
    @AppScope
    fun provideNavigatorHolder(): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }

}