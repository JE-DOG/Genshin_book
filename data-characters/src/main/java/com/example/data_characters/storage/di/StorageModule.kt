package com.example.data_characters.storage.di

import com.example.data_characters.storage.model.CharacterStorage
import com.example.data_characters.storage.repository.di.CharacterStorageRepositoryModule
import dagger.Module
import dagger.Provides
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

@Module(
    includes = [
        CharacterStorageRepositoryModule::class
    ]
)
class StorageModule {

    @Provides
    fun provideRealm(
        realmConfig: RealmConfiguration
    ): Realm{
        val realm = Realm.open(realmConfig)
        return realm
    }

    @Provides
    fun provideRealmConfig(): RealmConfiguration{
        val realmConfig = RealmConfiguration.Builder(
            setOf(
                CharacterStorage::class
            )
        )
            .compactOnLaunch()
            .build()
        return realmConfig
    }

}