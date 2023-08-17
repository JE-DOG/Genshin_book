package com.example.feature.profile.di.module

import com.example.feature.profile.data.ProfileRepositoryImpl
import com.example.feature.profile.data.network.service.ProfileNetworkService
import com.example.feature.profile.data.network.service.ProfileNetworkServiceImpl
import com.example.feature.profile.domain.ProfileRepository
import dagger.Module
import dagger.Provides
import io.github.jan.supabase.SupabaseClient

@Module
class FeatureProfileModule {

    @Provides
    fun provideProfileNetworkService(
        supabaseClient: SupabaseClient,
        userId: String
    ):ProfileNetworkService{
        return ProfileNetworkServiceImpl(
            supabaseClient,
            userId
        )
    }

    @Provides
    fun provideProfileRepository(
        networkService: ProfileNetworkService
    ): ProfileRepository {
        return ProfileRepositoryImpl(
            networkService
        )
    }

}