package com.example.genshinbook.data.storage.di

import com.example.genshinbook.data.storage.model.CharacterStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StorageModule {

    @Provides
    @Singleton
    fun provideRealm(
        realmConfig: RealmConfiguration
    ): Realm{
        val realm = Realm.open(realmConfig)
        return realm
    }

    @Provides
    @Singleton
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