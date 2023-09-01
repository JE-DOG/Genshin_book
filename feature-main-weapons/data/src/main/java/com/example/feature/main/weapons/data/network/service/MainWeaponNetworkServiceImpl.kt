package com.example.feature.main.weapons.data.network.service

import com.example.feature.main.weapons.data.network.model.WeaponJson
import com.example.feature.main.weapons.data.network.service.api.MainWeaponNetworkApi
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class MainWeaponNetworkServiceImpl(
    private val weaponApi: MainWeaponNetworkApi
): MainWeaponNetworkService {

    override fun getAllWeapons(): Single<List<WeaponJson>> {
        val result = weaponApi.getAllWeapons()
            .subscribeOn(Schedulers.io())
        return result
    }
}