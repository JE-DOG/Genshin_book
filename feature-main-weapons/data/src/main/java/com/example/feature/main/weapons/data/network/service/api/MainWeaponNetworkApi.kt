package com.example.feature.main.weapons.data.network.service.api

import com.example.feature.main.weapons.data.network.model.WeaponJson
import io.reactivex.Single
import retrofit2.http.GET

private const val GET_ALL_WEAPONS = "weapons/all"

interface MainWeaponNetworkApi {

    @GET(GET_ALL_WEAPONS)
    fun getAllWeapons(): Single<List<WeaponJson>>

}