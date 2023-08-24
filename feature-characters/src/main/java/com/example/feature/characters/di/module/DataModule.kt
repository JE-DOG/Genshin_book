package com.example.feature.characters.di.module

import com.example.data.characters.network.api.CharactersApi
import com.example.data.characters.network.repository.CharactersNetworkService
import com.example.data.characters.network.repository.CharactersNetworkServiceImpl
import com.example.data.characters.repository.CharactersRepositoryImpl
import com.example.data.characters.storage.repository.CharacterStorageService
import com.example.data.characters.storage.repository.CharacterStorageServiceImpl
import com.example.domain.characters.repository.CharactersRepository
import com.example.feature.characters.di.component.FeatureCharactersScope
import dagger.Module
import dagger.Provides
import io.realm.kotlin.Realm
import retrofit2.Retrofit

@Module
internal class DataModule {

    @Provides
    fun provideCharactersApi(
        retrofit: Retrofit
    ):CharactersApi{
        return retrofit.create(CharactersApi::class.java)
    }

    @Provides
    fun provideCharacterStorageService(
        realm: Realm
    ):CharacterStorageService{
        return CharacterStorageServiceImpl(
            realm = realm
        )
    }

    @FeatureCharactersScope
    @Provides
    fun provideCharactersNetworkService(
        charactersApi: CharactersApi
    ):CharactersNetworkService{
        return CharactersNetworkServiceImpl(
            api = charactersApi
        )
    }

    @FeatureCharactersScope
    @Provides
    fun provideCharactersRepository(
        characterNetwork: CharactersNetworkService,
        characterStorage: CharacterStorageService
    ): CharactersRepository {
        return CharactersRepositoryImpl(
            charactersNetwork = characterNetwork,
            characterStorageRepository = characterStorage
        )
    }

}