package com.example.genshinbook

import com.example.genshinbook.data.di.DataModule
import com.example.genshinbook.domain.di.DomainModule
import com.example.genshinbook.presentaion.di.PresentationModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [
    DataModule::class,
    PresentationModule::class,
    DomainModule::class,
])
@InstallIn(SingletonComponent::class)
class AppModule