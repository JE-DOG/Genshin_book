package com.example.genshinbook.data.di

import com.example.genshinbook.data.storage.di.StorageModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [ StorageModule::class ])
@InstallIn(SingletonComponent::class)
class DataModule