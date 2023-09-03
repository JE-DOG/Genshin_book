package com.example.feature.main.weapons.domain

import com.example.feature.main.weapons.domain.model.WeaponDomain
import io.reactivex.Completable
import io.reactivex.Single

interface MainWeaponRepository {

    fun getAllFromNetwork(): Single<List<WeaponDomain>>

    fun getAllFromStorage(): Single<List<WeaponDomain>>

    fun saveToStorage(weaponDomain: WeaponDomain): Completable

    fun deleteFromStorage(weaponDomain: WeaponDomain): Completable

}