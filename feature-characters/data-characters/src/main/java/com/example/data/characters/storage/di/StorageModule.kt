package com.example.data.characters.storage.di

import com.example.data.characters.storage.model.CharacterStorage
import com.example.data.characters.storage.model.ConstellationStorage
import com.example.data.characters.storage.model.PassiveTalentStorage
import com.example.data.characters.storage.model.SkillTalentStorage
import com.example.data.characters.storage.model.UpgradesStorage
import com.example.data.characters.storage.repository.di.CharacterStorageRepositoryModule
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
                CharacterStorage::class,
                ConstellationStorage::class,
                PassiveTalentStorage::class,
                SkillTalentStorage::class,
                UpgradesStorage::class
            )
        )
            .deleteRealmIfMigrationNeeded()
            .compactOnLaunch()
            .build()
        return realmConfig
    }

}