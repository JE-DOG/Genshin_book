package com.example.genshinbook.data.storage.di

import com.example.genshinbook.data.storage.model.CharacterStorage
import com.example.genshinbook.data.storage.repository.character.di.CharacterStorageRepositoryModule
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