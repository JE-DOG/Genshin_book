package com.example.app.demo.authorization

import android.app.Application
import com.example.app.demo.authorization.di.AppComponent
import com.example.app.demo.authorization.di.DaggerAppComponent
import com.example.feature.authorization.di.deps.FeatureAuthorizationDepsStore

class App: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        init()
    }

    private fun init() {
        FeatureAuthorizationDepsStore.featureAuthorizationComponentDeps = appComponent
    }

    companion object {
        lateinit var INSTANCE: App
            private set

        const val SHARED_PREFERENCES_NAME = "Genshin_book"
    }
}