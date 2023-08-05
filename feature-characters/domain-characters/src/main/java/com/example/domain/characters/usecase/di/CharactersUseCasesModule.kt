package com.example.domain.characters.usecase.di

import com.example.domain.characters.repository.CharactersRepository
import com.example.domain.characters.usecase.AddCharacterToStorageUseCase
import com.example.domain.characters.usecase.GetAllCharactersFromStorageUseCase
import com.example.domain.characters.usecase.GetAllInfoCharactersUseCase
import com.example.domain.characters.usecase.GetAllNameCharactersUseCase
import com.example.domain.characters.usecase.GetCurrentInfoCharacterUseCase
import com.example.domain.characters.usecase.IsCharacterInTheDatabaseUseCase
import com.example.domain.characters.usecase.RemoveCharacterFromStorageUseCase
import dagger.Module
import dagger.Provides

@Module
internal class CharactersUseCasesModule {

    @Provides
    fun provideIsCharacterInTheDataBaseUseCase(
        charactersRepository: CharactersRepository
    ): IsCharacterInTheDatabaseUseCase {
        return IsCharacterInTheDatabaseUseCase(charactersRepository)
    }

    @Provides
    fun provideAddCharacterToStorageUseCase(
        charactersRepository: CharactersRepository
    ): AddCharacterToStorageUseCase {
        return AddCharacterToStorageUseCase(charactersRepository)
    }

    @Provides
    fun provideRemoveCharacterFromStorageUseCase(
        charactersRepository: CharactersRepository
    ): RemoveCharacterFromStorageUseCase {
        return RemoveCharacterFromStorageUseCase(charactersRepository)
    }
    @Provides
    fun provideGetAllCharactersFromStorageUseCase(
        charactersRepository: CharactersRepository
    ): GetAllCharactersFromStorageUseCase {
        return GetAllCharactersFromStorageUseCase(
            charactersRepository = charactersRepository
        )
    }

    @Provides
    fun provideGetAllInfoCharactersUseCase(
        charactersRepository: CharactersRepository
    ): GetAllInfoCharactersUseCase {
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