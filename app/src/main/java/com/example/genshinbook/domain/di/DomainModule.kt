package com.example.genshinbook.domain.di

import com.example.genshinbook.domain.repository.characters.di.CharacterRepositoryModule
import com.example.genshinbook.domain.usecase.characters.di.CharactersDomainModule
import dagger.Module

@Module(
    includes = [
        //character
        CharactersDomainModule::class,
        CharacterRepositoryModule::class
    ]
)
class DomainModule