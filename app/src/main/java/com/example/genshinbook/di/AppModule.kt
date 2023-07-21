package com.example.genshinbook.di

import com.example.data_characters.di.DataModule
import com.example.domain_characters.domain.di.DomainModule
import com.example.genshinbook.presentaion.di.PresentationModule
import com.example.genshinbook.presentaion.di.veiwModelStore.ViewModelStoreComponent
import dagger.Module

@Module(
    includes = [
        com.example.data_characters.di.DataModule::class,
        PresentationModule::class,
        com.example.domain_characters.domain.di.DomainModule::class,
    ],
    subcomponents = [
        ViewModelStoreComponent::class
    ]
)
class AppModule