package com.example.app.demo.authorization

import android.app.Application
import com.example.app.demo.authorization.di.AppComponent
import com.example.app.demo.authorization.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        init()
    }

    private fun init() {
        appComponent = DaggerAppComponent.factory().create(this)
    }

    companion object {
        lateinit var INSTANCE: App
            private set

        const val SHARED_PREFERENCES_NAME = "Genshin_book"
    }
}