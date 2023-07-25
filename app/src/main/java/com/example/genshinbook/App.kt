package com.example.genshinbook

import android.app.Application
import com.example.genshinbook.di.AppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        INSTANCE = this
        //components

//        appComponent = DaggerAppComponent.create()

    }

    companion object{
        lateinit var INSTANCE: App
            private set

    }
}