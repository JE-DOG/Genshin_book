package com.example.feature.authorization.di.module

import android.content.SharedPreferences
import com.example.feature.authorization.data.AuthorizationRepositoryImpl
import com.example.feature.authorization.data.network.service.AuthorizationNetworkService
import com.example.feature.authorization.data.network.service.AuthorizationNetworkServiceImpl
import com.example.feature.authorization.data.storage.service.AuthorizationStorageService
import com.example.feature.authorization.data.storage.service.AuthorizationStorageServiceImpl
import com.example.feature.authorization.domain.AuthorizationRepository
import dagger.Module
import dagger.Provides
import io.github.jan.supabase.SupabaseClient

@Module
class FeatureAuthorizationModule {

    @Provides
    fun provideAuthorizationNetworkService(
        supabaseClient: SupabaseClient
    ):AuthorizationNetworkService{
        return AuthorizationNetworkServiceImpl(
            supabaseClient
        )
    }

    @Provides
    fun provideAuthorizationStorageService(
        sharedPreference: SharedPreferences
    ):AuthorizationStorageService{
        return AuthorizationStorageServiceImpl(
            sharedPreference
        )
    }

    @Provides
    fun provideAuthorizationRepository(
        networkService: AuthorizationNetworkService,
        storageService: AuthorizationStorageService
    ): AuthorizationRepository {
        return AuthorizationRepositoryImpl(
            storageService,
            networkService
        )
    }

}