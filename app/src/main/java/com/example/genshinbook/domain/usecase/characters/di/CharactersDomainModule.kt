package com.example.genshinbook.domain.usecase.characters.di

import com.example.genshinbook.data.network.repository.characters.CharactersNetwork
import com.example.genshinbook.data.network.repository.characters.CharactersNetworkImpl
import com.example.genshinbook.data.repository.characters.CharactersRepositoryImpl
import com.example.genshinbook.data.storage.repository.character.CharacterStorageRepository
import com.example.genshinbook.data.storage.repository.character.CharacterStorageRepositoryImpl
import com.example.genshinbook.domain.repository.characters.CharactersRepository
import com.example.genshinbook.domain.usecase.characters.*
import dagger.Module
import dagger.Provides
import io.realm.kotlin.Realm

@Module
class CharactersDomainModule {

    @Provides
    fun provideIsCharacterInTheDataBaseUseCase(
        charactersRepository: CharactersRepository
    ): IsCharacterInTheDatabaseUseCase{
        return IsCharacterInTheDatabaseUseCase(charactersRepository)
    }

    @Provides
    fun provideAddCharacterToStorageUseCase(
        charactersRepository: CharactersRepository
    ): AddCharacterToStorageUseCase{
        return AddCharacterToStorageUseCase(charactersRepository)
    }

    @Provides
    fun provideRemoveCharacterFromStorageUseCase(
        charactersRepository: CharactersRepository
    ): RemoveCharacterFromStorageUseCase{
        return RemoveCharacterFromStorageUseCase(charactersRepository)
    }
    @Provides
    fun provideGetAllCharactersFromStorageUseCase(
        charactersRepository: CharactersRepository
    ): GetAllCharactersFromStorageUseCase{
        return GetAllCharactersFromStorageUseCase(
            charactersRepository = charactersRepository
        )
    }

    @Provides
    fun provideGetAllInfoCharactersUseCase(
        charactersRepository: CharactersRepository
    ): GetAllInfoCharactersUseCase{
        return GetAllInfoCharactersUseCase(
            charactersRepository = charactersRepository
        )
    }

    @Provides
    fun provideGetAllNameCharactersUseCase(
        charactersRepository: CharactersRepository
    ): GetAllNameCharactersUseCase {
        return GetAllNameCharactersUseCase(
            charactersRepository = charactersRepository
        )
    }

    @Provides
    fun provideGetCurrentInfoCharacterUseCase(
        charactersRepository: CharactersRepository
    ): GetCurrentInfoCharacterUseCase {
        return GetCurrentInfoCharacterUseCase(
            charactersRepository = charactersRepository
        )
    }

}