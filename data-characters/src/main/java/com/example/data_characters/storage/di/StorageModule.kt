package com.example.data_characters.storage.di

import com.example.data_characters.storage.model.SkillTalentStorage
import com.example.data_characters.storage.model.CharacterStorage
import com.example.data_characters.storage.model.ConstellationStorage
import com.example.data_characters.storage.model.PassiveTalentStorage
import com.example.data_characters.storage.model.UpgradesStorage
import com.example.data_characters.storage.repository.di.CharacterStorageRepositoryModule
import dagger.Module
import dagger.Provides
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.migration.AutomaticSchemaMigration
import io.realm.kotlin.migration.RealmMigration

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