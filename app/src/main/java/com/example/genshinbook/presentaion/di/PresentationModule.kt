package com.example.genshinbook.presentaion.di

import com.example.genshinbook.presentaion.screen.main.elements.characters.di.CharactersModule
import dagger.Module

@Module(includes = [ CharactersModule::class ])
class PresentationModule