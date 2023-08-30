package com.example.feature.main.weapons.data.network.service

import com.example.feature.main.weapons.data.network.model.WeaponJson
import io.reactivex.Single

interface MainWeaponNetworkService {

    fun getAllWeapons(): Single<List<WeaponJson>>

}