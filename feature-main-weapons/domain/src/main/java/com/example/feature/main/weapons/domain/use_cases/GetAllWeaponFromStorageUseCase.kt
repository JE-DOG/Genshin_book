package com.example.feature.main.weapons.domain.use_cases

import com.example.feature.main.weapons.domain.MainWeaponRepository
import com.example.feature.main.weapons.domain.model.WeaponDomain
import io.reactivex.Single

class GetAllWeaponFromStorageUseCase(
    private val weaponRepository: MainWeaponRepository
) {

    fun execute(): Single<List<WeaponDomain>> {
        val result = weaponRepository.getAllFromStorage()
        return result
    }

}