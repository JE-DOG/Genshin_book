package com.example.genshinbook.di

import dagger.Component

@AppScope
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {


}