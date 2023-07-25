package com.example.domain.characters.di

import com.example.domain.characters.repository.CharactersRepository
import com.example.domain.characters.usecase.AddCharacterToStorageUseCase
import com.example.domain.characters.usecase.GetAllCharactersFromStorageUseCase
import com.example.domain.characters.usecase.GetAllInfoCharactersUseCase
import com.example.domain.characters.usecase.GetAllNameCharactersUseCase
import com.example.domain.characters.usecase.GetCurrentInfoCharacterUseCase
import com.example.domain.characters.usecase.IsCharacterInTheDatabaseUseCase
import com.example.domain.characters.usecase.RemoveCharacterFromStorageUseCase
import com.example.domain.characters.usecase.di.CharactersUseCasesModule
import dagger.Component

@CharactersDomainScope
@Component(
    modules = [
        CharactersUseCasesModule::class
    ],
    dependencies = [
        CharactersDomainDeps::class
    ]
)
interface CharactersDomainComponent {

    @Component.Factory
    interface Factory {

        fun create(
            charactersDomainDeps: CharactersDomainDeps
        ): CharactersDomainComponent

    }

    val addCharacterToStorageUseCase: AddCharacterToStorageUseCase
    val getAllCharactersFromStorageUseCase: GetAllCharactersFromStorageUseCase
    val getAllInfoCharactersUseCase: GetAllInfoCharactersUseCase
    val getAllNameCharactersUseCase: GetAllNameCharactersUseCase
    val getCurrentInfoCharacterUseCase: GetCurrentInfoCharacterUseCase
    val isCharacterInTheDatabaseUseCase: IsCharacterInTheDatabaseUseCase
    val removeCharacterInTheDatabaseUseCase: RemoveCharacterFromStorageUseCase

}

interface CharactersDomainDeps {

    val characterRepository: CharactersRepository

}