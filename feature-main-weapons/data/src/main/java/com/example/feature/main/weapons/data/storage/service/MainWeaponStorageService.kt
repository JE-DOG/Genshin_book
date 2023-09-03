package com.example.feature.main.weapons.data.storage.service

import com.example.feature.main.weapons.data.model.service.storage.model.WeaponEntity
import com.example.feature.main.weapons.domain.model.WeaponDomain
import io.reactivex.Completable
import io.reactivex.Single

interface MainWeaponStorageService {

    fun getAllWeapons(): Single<List<WeaponEntity>>

    fun save(weaponEntity: WeaponEntity): Completable

    fun delete(weaponEntity: WeaponEntity): Completable

}