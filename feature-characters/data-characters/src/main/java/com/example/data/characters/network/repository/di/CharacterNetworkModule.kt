package com.example.data.characters.network.repository.di

import com.example.data.characters.network.api.CharactersApi
import com.example.data.characters.network.repository.CharactersNetwork
import com.example.data.characters.network.repository.CharactersNetworkImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class CharacterNetworkModule {

    @Provides
    fun provideCharacterApi(
        retrofit: Retrofit
    ): CharactersApi {
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