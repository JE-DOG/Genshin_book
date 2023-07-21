package com.example.genshinbook.data.repository.characters.di

import com.example.genshinbook.data.network.repository.characters.CharactersNetwork
import com.example.domain_characters.CharactersRepositoryImpl
import com.example.genshinbook.data.storage.repository.character.CharacterStorageRepository
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