package com.example.data_characters.di

import com.example.data_characters.network.model.CharacterNetwork
import com.example.data_characters.network.repository.CharactersNetworkImpl
import com.example.data_characters.repository.CharactersRepositoryImpl
import com.example.data_characters.storage.model.CharacterStorage
import com.example.data_characters.storage.repository.CharacterStorageRepositoryImpl
import com.example.domain_characters.repository.CharactersRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideCharactersRepository(
        characterNetwork: CharactersNetworkImpl,
        characterStorage: CharacterStorageRepositoryImpl
    ):CharactersRepository {
        return CharactersRepositoryImpl(
            charactersNetwork = characterNetwork,
            characterStorageRepository = characterStorage
        )
    }

}