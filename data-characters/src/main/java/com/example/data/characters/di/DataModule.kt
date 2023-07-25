package com.example.data.characters.di

import com.example.data.characters.network.di.NetworkModule
import com.example.data.characters.network.repository.CharactersNetworkImpl
import com.example.data.characters.repository.CharactersRepositoryImpl
import com.example.data.characters.storage.di.StorageModule
import com.example.data.characters.storage.repository.CharacterStorageRepositoryImpl
import com.example.domain.characters.repository.CharactersRepository
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        StorageModule::class,
        NetworkModule::class
    ]
)
internal class DataModule {

    @DataCharactersScope
    @Provides
    fun provideCharactersRepository(
        characterNetwork: CharactersNetworkImpl,
        characterStorage: CharacterStorageRepositoryImpl
    ): CharactersRepository {
        return CharactersRepositoryImpl(
            charactersNetwork = characterNetwork,
            characterStorageRepository = characterStorage
        )
    }

}