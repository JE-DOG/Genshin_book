package com.example.genshinbook

import com.example.genshinbook.data.di.DataModule
import com.example.genshinbook.domain.di.DomainModule
import com.example.genshinbook.presentaion.di.PresentationModule
import dagger.Module

@Module(includes = [
    DataModule::class,
    PresentationModule::class,
    DomainModule::class,
])
class AppModule