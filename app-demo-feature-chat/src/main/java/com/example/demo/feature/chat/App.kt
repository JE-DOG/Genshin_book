package com.example.demo.feature.chat

import android.app.Application

class App: Application() {

//    val appComponent by lazy {
//        DaggerAppComponent.create()
//    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        init()
    }

    private fun init() {
//        FeatureChatsListDepsStore.featureChatsListDeps = appComponent
    }

    companion object {
        lateinit var INSTANCE: App
            private set
    }
}