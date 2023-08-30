package com.example.feature.main.weapons.vm

import com.example.feature.main.weapons.model.WeaponPresentation

data class WeaponsTabViewState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isOffline: Boolean = false,
    val weapons: MutableList<WeaponPresentation> = mutableListOf()
)