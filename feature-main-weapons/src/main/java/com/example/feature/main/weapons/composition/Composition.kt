package com.example.feature.main.weapons.composition

import androidx.compose.runtime.compositionLocalOf
import com.example.feature.main.weapons.vm.WeaponsTabViewModel

val LocalFeatureWeaponViewModel = compositionLocalOf<WeaponsTabViewModel> {
    throw IllegalArgumentException()
}