package com.example.genshinbook.data.network.repository.characters.di

import com.example.genshinbook.data.network.repository.characters.CharactersNetwork
import com.example.genshinbook.data.network.repository.characters.CharactersNetworkImpl
import dagger.Module
import dagger.Provides

@Module
class CharacterNetworkModule {

    //todo provide character network repo

    @Provides
    fun provideCharactersNetwork(): CharactersNetwork {
        return CharactersNetworkImpl()
    }

}