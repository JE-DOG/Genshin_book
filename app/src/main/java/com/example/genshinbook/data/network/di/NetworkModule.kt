package com.example.genshinbook.data.network.di

import com.example.genshinbook.data.network.repository.characters.di.CharacterNetworkModule
import dagger.Module

@Module(
    includes = [
        CharacterNetworkModule::class
    ]
)
class NetworkModule{

    //todo provide retrofit

}