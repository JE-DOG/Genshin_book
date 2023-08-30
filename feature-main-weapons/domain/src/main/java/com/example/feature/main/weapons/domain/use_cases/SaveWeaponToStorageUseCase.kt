package com.example.feature.main.weapons.domain.use_cases

import com.example.feature.main.weapons.domain.MainWeaponRepository
import com.example.feature.main.weapons.domain.model.WeaponDomain
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class SaveWeaponToStorageUseCase @Inject constructor(
    private val weaponRepository: MainWeaponRepository
) {

    fun execute(weaponDomain: WeaponDomain): Completable {
        val result = weaponRepository.saveToStorage(weaponDomain)
        return result
    }

}