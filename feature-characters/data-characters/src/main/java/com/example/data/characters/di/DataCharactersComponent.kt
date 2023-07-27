package com.example.data.characters.di

import com.example.domain.characters.di.CharactersDomainDeps
import com.example.domain.characters.repository.CharactersRepository
import dagger.Component

@DataCharactersScope
@Component(
    modules = [
        DataModule::class
    ]
)
interface DataCharactersComponent: CharactersDomainDeps {

    override val characterRepository: CharactersRepository

}