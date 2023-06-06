package com.example.genshinbook.data.di

import com.example.genshinbook.data.network.di.NetworkModule
import com.example.genshinbook.data.storage.di.StorageModule
import dagger.Module

@Module(includes = [
    StorageModule::class,
    NetworkModule::class
])
class DataModule