package com.example.genshinbook.di

import com.example.genshinbook.data.di.DataModule
import com.example.genshinbook.domain.di.DomainModule
import com.example.genshinbook.presentaion.di.PresentationModule
import com.example.genshinbook.presentaion.di.veiwModelStore.ViewModelStoreComponent
import dagger.Module

@Module(
    includes = [
        DataModule::class,
        PresentationModule::class,
        DomainModule::class,
    ],
    subcomponents = [
        ViewModelStoreComponent::class
    ]
)
class AppModule