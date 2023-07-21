package com.example.data_characters.di

import com.example.data_characters.network.di.NetworkModule
import com.example.data_characters.storage.di.StorageModule
import dagger.Component

@Component(
    modules = [
        StorageModule::class,
        NetworkModule::class,
        DataModule::class
    ]
)
interface DataCharactersComponent {



}