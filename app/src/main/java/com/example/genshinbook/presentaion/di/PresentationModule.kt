package com.example.genshinbook.presentaion.di

import com.example.genshinbook.presentaion.screen.main.elements.characters.di.CharactersModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [ CharactersModule::class ])
@InstallIn(SingletonComponent::class)
class PresentationModule