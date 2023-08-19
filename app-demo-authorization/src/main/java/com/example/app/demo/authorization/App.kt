package com.example.app.demo.authorization

import android.app.Application
import com.example.app.demo.authorization.di.AppComponent
import com.example.app.demo.authorization.di.DaggerAppComponent
import com.example.feature.authorization.di.deps.FeatureAuthorizationDepsStore
import com.example.feature.profile.di.deps.FeatureProfileDepsStore

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
        FeatureAuthorizationDepsStore.deps = appComponent
        FeatureProfileDepsStore.deps = appComponent
    }

    companion object {
        lateinit var INSTANCE: App
            private set

        const val SHARED_PREFERENCES_NAME = "Genshin_book"
    }
}