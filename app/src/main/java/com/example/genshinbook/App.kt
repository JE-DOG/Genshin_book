package com.example.genshinbook

import android.app.Application
import com.example.feature.add.chat.di.component.FeatureAddChatDepsStore
import com.example.feature.authorization.di.deps.FeatureAuthorizationDepsStore
import com.example.feature.chat.dialog.di.component.deps.FeatureChatDialogDepsStore
import com.example.feature.chats.list.di.component.FeatureChatsListDepsStore
import com.example.feature.profile.di.deps.FeatureProfileDepsStore
import com.example.genshinbook.di.AppComponent
import com.example.genshinbook.di.DaggerAppComponent

class App: Application() {

    val appComponent by lazy {
        DaggerAppComponent
            .factory()
            .create(this)
    }

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        INSTANCE = this
        with(appComponent){
            FeatureAuthorizationDepsStore.deps = this
            FeatureAddChatDepsStore.deps = this
            FeatureChatDialogDepsStore.deps = this
            FeatureChatsListDepsStore.deps = this
            FeatureProfileDepsStore.deps = this
        }
    }

    companion object{
        lateinit var INSTANCE: App
            private set

        const val SHARED_PREFERENCES_NAME = "Genshin_book"
    }
}