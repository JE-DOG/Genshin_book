package com.example.demo.feature.chat

import android.app.Application
import com.example.demo.feature.chat.di.DaggerAppComponent
import com.example.feature.add.chat.di.component.FeatureAddChatDepsStore
import com.example.feature.chats.list.di.component.FeatureChatsListDepsStore
import com.github.terrakok.cicerone.Cicerone

class App: Application() {

    private val cicerone = Cicerone.create()
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    val appComponent by lazy {
        DaggerAppComponent.create()
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        init()
    }

    private fun init() {
        FeatureChatsListDepsStore.featureChatsListDeps = appComponent
        FeatureAddChatDepsStore.featureAddChatDeps = appComponent
    }

    companion object {
        lateinit var INSTANCE: App
            private set
    }
}