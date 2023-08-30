package com.example.feature.main.weapons.data

import com.example.feature.main.weapons.data.model.service.storage.model.WeaponEntity
import com.example.feature.main.weapons.data.network.service.MainWeaponNetworkService
import com.example.feature.main.weapons.data.storage.service.MainWeaponStorageService
import com.example.feature.main.weapons.domain.MainWeaponRepository
import com.example.feature.main.weapons.domain.model.WeaponDomain
import io.reactivex.Completable
import io.reactivex.Single

class MainWeaponRepositoryImpl(
    private val networkService: MainWeaponNetworkService,
    private val storageService: MainWeaponStorageService
): MainWeaponRepository {

    override fun getAllFromNetwork(): Single<List<WeaponDomain>> {
        val result = networkService.getAllWeapons()
            .map {  weapons ->
                weapons.map {
                    it.toDomain()
                }
            }
        return result
    }

    override fun getAllFromStorage(): Single<List<WeaponDomain>> {
        val result = storageService.getAllWeapons()
            .map {  weapons ->
                weapons.map {
                    it
                        .toDomain()
                }
            }
        return result
    }

    override fun saveToStorage(weaponDomain: WeaponDomain): Completable {
        val result = storageService.save(
            WeaponEntity
                .fromDomain(weaponDomain)
        )
        return result
    }

    override fun deleteFromStorage(weaponDomain: WeaponDomain): Completable {
        val result = storageService.save(
            WeaponEntity
                .fromDomain(weaponDomain)
        )
        return result
    }
}