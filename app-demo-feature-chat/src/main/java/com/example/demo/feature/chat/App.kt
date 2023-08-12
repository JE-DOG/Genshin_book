package com.example.demo.feature.chat

import android.app.Application
import com.example.demo.feature.chat.di.DaggerAppComponent
import com.example.feature.add.chat.di.component.FeatureAddChatDepsStore
import com.example.feature.chat.dialog.di.component.deps.FeatureChatDialogDepsStore
import com.example.feature.chats.list.di.component.FeatureChatsListDepsStore

class App: Application() {

    val appComponent by lazy {
        DaggerAppComponent.create()
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        initModulesComponent()
    }

    private fun initModulesComponent() {
        FeatureChatsListDepsStore.featureChatsListDeps = appComponent
        FeatureAddChatDepsStore.featureAddChatDeps = appComponent
        FeatureChatDialogDepsStore.featureChatDialogDeps = appComponent
    }

    companion object {
        lateinit var INSTANCE: App
            private set
    }
}