package com.example.feature.main.weapons.data.storage.service

import com.example.feature.main.weapons.data.model.service.storage.model.WeaponEntity
import com.example.feature.main.weapons.data.network.service.MainWeaponNetworkService
import com.example.feature.main.weapons.data.storage.service.dao.MainWeaponDao
import com.example.feature.main.weapons.domain.model.WeaponDomain
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class MainWeaponStorageServiceImpl(
    private val weaponDao: MainWeaponDao
): MainWeaponStorageService {

    override fun getAllWeapons(): Single<List<WeaponEntity>> {
        val result = weaponDao.getAllWeapons()
            .subscribeOn(Schedulers.io())
        return result
    }

    override fun save(weaponEntity: WeaponEntity): Completable {
        val result = weaponDao.saveWeapon(weaponEntity)
            .subscribeOn(Schedulers.io())
        return result
    }

    override fun delete(weaponEntity: WeaponEntity): Completable {
        val result = weaponDao.deleteWeapon(weaponEntity)
            .subscribeOn(Schedulers.io())
        return result
    }

}