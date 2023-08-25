package com.example.feature.main.weapons.domain.use_cases

import com.example.feature.main.weapons.domain.MainWeaponRepository
import com.example.feature.main.weapons.domain.model.WeaponDomain
import io.reactivex.Single

class SaveWeaponToStorageUseCase(
    private val weaponRepository: MainWeaponRepository
) {

    fun execute(weaponDomain: WeaponDomain): Single<Boolean> {
        val result = weaponRepository.saveToStorage(weaponDomain)
        return result
    }

}