package com.example.genshinbook

import android.app.Application
import com.example.data_characters.di.DaggerDataCharactersComponent
import com.example.domain_characters.di.CharactersDomainComponent
import com.example.domain_characters.di.DaggerCharactersDomainComponent
import com.example.genshinbook.di.AppComponent

class App: Application() {

    lateinit var appComponent: AppComponent
    lateinit var charactersDomainComponent: CharactersDomainComponent

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        INSTANCE = this
        //components
        val dataCharactersComponent = DaggerDataCharactersComponent.create()
        charactersDomainComponent = DaggerCharactersDomainComponent
            .factory()
            .create(dataCharactersComponent)

//        appComponent = DaggerAppComponent.create()

    }

    companion object{
        lateinit var INSTANCE: App
            private set

    }
}