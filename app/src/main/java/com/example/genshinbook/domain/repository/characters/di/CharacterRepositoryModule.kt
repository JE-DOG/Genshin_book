package com.example.genshinbook.domain.repository.characters.di

import com.example.genshinbook.data.network.repository.characters.CharactersNetwork
import com.example.genshinbook.data.network.repository.characters.CharactersNetworkImpl
import com.example.genshinbook.data.repository.characters.CharactersRepositoryImpl
import com.example.genshinbook.data.storage.repository.character.CharacterStorageRepository
import com.example.genshinbook.data.storage.repository.character.CharacterStorageRepositoryImpl
import com.example.genshinbook.domain.repository.characters.CharactersRepository
import dagger.Module
import dagger.Provides
import io.realm.kotlin.Realm

@Module
class CharacterRepositoryModule {

    @Provides
    fun provideCharactersRepository(
        charactersNetwork: CharactersNetwork,
        characterStorageRepository: CharacterStorageRepository
    ): CharactersRepository {

        return CharactersRepositoryImpl(
            charactersNetwork = charactersNetwork,
            characterStorageRepository
        )

    }

}