package com.example.feature.main.weapons.di.module

import android.content.Context
import androidx.room.Room
import com.example.feature.main.weapons.data.MainWeaponRepositoryImpl
import com.example.feature.main.weapons.data.network.service.MainWeaponNetworkService
import com.example.feature.main.weapons.data.network.service.MainWeaponNetworkServiceImpl
import com.example.feature.main.weapons.data.network.service.api.MainWeaponNetworkApi
import com.example.feature.main.weapons.data.storage.service.MainWeaponStorageService
import com.example.feature.main.weapons.data.storage.service.MainWeaponStorageServiceImpl
import com.example.feature.main.weapons.data.storage.service.dao.MainWeaponDao
import com.example.feature.main.weapons.data.storage.service.data_base.MainWeaponRoomDataBase
import com.example.feature.main.weapons.di.component.FeatureMainWeaponsScope
import com.example.feature.main.weapons.domain.MainWeaponRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class DataModule {

    @Provides
    @FeatureMainWeaponsScope
    fun provideRoomDataBase(
        context: Context
    ): MainWeaponRoomDataBase {
        return Room
            .databaseBuilder(
                context,
                MainWeaponRoomDataBase::class.java,
                "MainWeaponRoomDataBase"
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @FeatureMainWeaponsScope
    fun provideMainWeaponDao(
        weaponDataBase: MainWeaponRoomDataBase
    ):MainWeaponDao{
        return weaponDataBase.dao()
    }

    @Provides
    @FeatureMainWeaponsScope
    fun provideMainWeaponStorageService(
        weaponDao: MainWeaponDao
    ): MainWeaponStorageService {
        return MainWeaponStorageServiceImpl(
            weaponDao
        )
    }

    @Provides
    @FeatureMainWeaponsScope
    fun provideMainWeaponNetworkApi(
        retrofit: Retrofit
    ): MainWeaponNetworkApi {
        return retrofit.create(MainWeaponNetworkApi::class.java)
    }

    @Provides
    @FeatureMainWeaponsScope
    fun provideMainWeaponNetworkService(
        weaponNetworkApi: MainWeaponNetworkApi
    ): MainWeaponNetworkService {
        return MainWeaponNetworkServiceImpl(
            weaponNetworkApi
        )
    }

    @Provides
    @FeatureMainWeaponsScope
    fun provideMainWeaponRepository(
        mainWeaponNetworkService: MainWeaponNetworkService,
        mainWeaponStorageService: MainWeaponStorageService
    ): MainWeaponRepository {
        return MainWeaponRepositoryImpl(
            mainWeaponNetworkService,
            mainWeaponStorageService
        )
    }

}