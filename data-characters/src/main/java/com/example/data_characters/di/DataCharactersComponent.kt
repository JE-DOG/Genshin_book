package com.example.data_characters.di

import com.example.domain_characters.di.CharactersDomainDeps
import com.example.domain_characters.repository.CharactersRepository
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