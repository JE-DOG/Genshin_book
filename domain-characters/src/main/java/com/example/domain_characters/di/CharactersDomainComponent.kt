package com.example.domain_characters.di

import com.example.domain_characters.repository.CharactersRepository
import com.example.domain_characters.usecase.di.CharactersUseCasesModule
import dagger.Component

@Component(
    modules = [
        CharactersUseCasesModule::class
    ]
)
interface CharactersDomainComponent {

    @Component.Factory
    interface Factory {

        fun create(
            characterRepository: CharactersRepository
        ): CharactersDomainComponent

    }

}