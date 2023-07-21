package com.example.data_characters.repository.di

import com.example.data_characters.network.repository.CharactersNetwork
import com.example.domain_characters.CharactersRepositoryImpl
import com.example.data_characters.storage.repository.CharacterStorageRepository
import com.example.domain_characters.domain.repository.characters.CharactersRepository
import dagger.Module
import dagger.Provides

@Module
class CharacterRepositoryModule {

    @Provides
    fun provideCharactersRepository(
        charactersNetwork: CharactersNetwork,
        characterStorageRepository: CharacterStorageRepository
    ): CharactersRepository {

        return com.example.domain_characters.CharactersRepositoryImpl(
            charactersNetwork = charactersNetwork,
            characterStorageRepository
        )

    }

}