package com.example.genshinbook

import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

    }

    companion object{

        lateinit var INSTANCE: App
            private set

    }
}