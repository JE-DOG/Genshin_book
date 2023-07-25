package com.example.data.characters.storage.repository.di

import com.example.data.characters.storage.repository.CharacterStorageRepository
import com.example.data.characters.storage.repository.CharacterStorageRepositoryImpl
import dagger.Module
import dagger.Provides
import io.realm.kotlin.Realm

@Module
class CharacterStorageRepositoryModule {

    @Provides
    fun provideStorageCharacterRepository(
        database: Realm
    ): CharacterStorageRepository {
        return CharacterStorageRepositoryImpl(database)
    }

}