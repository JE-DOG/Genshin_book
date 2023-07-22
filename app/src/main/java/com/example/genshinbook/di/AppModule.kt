package com.example.genshinbook.di

import com.example.genshinbook.presentaion.di.PresentationModule
import com.example.genshinbook.presentaion.di.veiwModelStore.ViewModelStoreComponent
import dagger.Module

@Module(
    includes = [
        PresentationModule::class,
    ]
)
class AppModule