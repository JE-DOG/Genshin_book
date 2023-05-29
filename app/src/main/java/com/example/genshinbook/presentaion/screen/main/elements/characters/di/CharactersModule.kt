package com.example.genshinbook.presentaion.screen.main.elements.characters.di

import com.example.genshinbook.data.network.repository.characters.CharactersNetwork
import com.example.genshinbook.data.network.repository.characters.CharactersNetworkImpl
import com.example.genshinbook.data.repository.characters.CharactersRepositoryImpl
import com.example.genshinbook.data.storage.repository.character.CharacterStorageRepository
import com.example.genshinbook.data.storage.repository.character.CharacterStorageRepositoryImpl
import com.example.genshinbook.domain.repository.characters.CharactersRepository
import com.example.genshinbook.domain.usecase.characters.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CharactersModule {

    @Provides
    @Singleton
    fun provideIsCharacterInTheDataBaseUseCase(
        charactersRepository: CharactersRepository
    ): IsCharacterInTheDatabaseUseCase{
        return IsCharacterInTheDatabaseUseCase(charactersRepository)
    }

    @Provides
    @Singleton
    fun provideAddCharacterToStorageUseCase(
        charactersRepository: CharactersRepository
    ): AddCharacterToStorageUseCase{
        return AddCharacterToStorageUseCase(charactersRepository)
    }

    @Provides
    @Singleton
    fun provideRemoveCharacterFromStorageUseCase(
        charactersRepository: CharactersRepository
    ): RemoveCharacterFromStorageUseCase{
        return RemoveCharacterFromStorageUseCase(charactersRepository)
    }

    @Provides
    @Singleton
    fun provideGetAllInfoCharactersUseCase(
        charactersRepository: CharactersRepository
    ): GetAllInfoCharactersUseCase{
        return GetAllInfoCharactersUseCase(
            charactersRepository = charactersRepository
        )
    }

    @Provides
    @Singleton
    fun provideGetAllNameCharactersUseCase(
        charactersRepository: CharactersRepository
    ): GetAllNameCharactersUseCase {
        return GetAllNameCharactersUseCase(
            charactersRepository = charactersRepository
        )
    }

    @Provides
    @Singleton
    fun provideGetCurrentInfoCharacterUseCase(
        charactersRepository: CharactersRepository
    ): GetCurrentInfoCharacterUseCase {
        return GetCurrentInfoCharacterUseCase(
            charactersRepository = charactersRepository
        )
    }



    @Provides
    @Singleton
    fun provideCharactersRepository(
        charactersNetwork: CharactersNetwork,
        characterStorageRepository: CharacterStorageRepository
    ):CharactersRepository{

        return CharactersRepositoryImpl(
            charactersNetwork = charactersNetwork,
            characterStorageRepository
        )

    }

    @Provides
    @Singleton
    fun provideStorageCharacterRepository(
        database: Realm
    ):CharacterStorageRepository{
        return CharacterStorageRepositoryImpl(database)
    }

    @Provides
    @Singleton
    fun provideCharactersNetwork(): CharactersNetwork{
        return CharactersNetworkImpl()
    }

}