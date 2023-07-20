package com.example.genshinbook

import android.app.Application
import com.example.genshinbook.di.AppComponent
import com.example.genshinbook.di.DaggerAppComponent
import com.example.genshinbook.presentaion.di.veiwModelStore.ViewModelStoreComponent

class App: Application() {

    lateinit var appComponent: AppComponent
    //subcomponents
    lateinit var viewModelStoreComponent: ViewModelStoreComponent

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        INSTANCE = this
        //components

        appComponent = DaggerAppComponent.create()
        //subcomponents
        viewModelStoreComponent = appComponent.viewModelStoreComponent.build()
    }

    companion object{

        lateinit var INSTANCE: App
            private set

    }
}