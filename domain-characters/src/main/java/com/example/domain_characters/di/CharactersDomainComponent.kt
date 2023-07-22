package com.example.domain_characters.di

import com.example.domain_characters.repository.CharactersRepository
import com.example.domain_characters.usecase.AddCharacterToStorageUseCase
import com.example.domain_characters.usecase.GetAllCharactersFromStorageUseCase
import com.example.domain_characters.usecase.GetAllInfoCharactersUseCase
import com.example.domain_characters.usecase.GetAllNameCharactersUseCase
import com.example.domain_characters.usecase.GetCurrentInfoCharacterUseCase
import com.example.domain_characters.usecase.IsCharacterInTheDatabaseUseCase
import com.example.domain_characters.usecase.RemoveCharacterFromStorageUseCase
import com.example.domain_characters.usecase.di.CharactersUseCasesModule
import dagger.BindsInstance
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

    val addCharacterToStorageUseCase:AddCharacterToStorageUseCase
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