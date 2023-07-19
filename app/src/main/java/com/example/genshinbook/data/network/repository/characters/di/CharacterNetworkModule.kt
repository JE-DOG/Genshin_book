package com.example.genshinbook.data.network.repository.characters.di

import com.example.genshinbook.data.network.api.CharactersApi
import com.example.genshinbook.data.network.repository.characters.CharactersNetwork
import com.example.genshinbook.data.network.repository.characters.CharactersNetworkImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class CharacterNetworkModule {

    @Provides
    fun provideCharacterApi(
        retrofit: Retrofit
    ): CharactersApi{
        val characterApi = retrofit.create(CharactersApi::class.java)
        return characterApi
    }

    @Provides
    fun provideCharactersNetwork(
        charactersApi: CharactersApi
    ): CharactersNetwork {
        return CharactersNetworkImpl(charactersApi)
    }

}