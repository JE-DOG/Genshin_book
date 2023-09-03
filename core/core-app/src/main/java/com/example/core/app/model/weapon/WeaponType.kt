package com.example.core.app.model.weapon

import androidx.annotation.DrawableRes
import com.example.core.app.R

enum class WeaponType(
    val weaponName: String,
    @DrawableRes
    val resIcon: Int
) {

    BOW(
        weaponName = "Bow",
        resIcon = R.drawable.ic_weapon_type_bow
    ),
    CATALYST(
        weaponName = "Catalyst",
        resIcon = R.drawable.ic_weapon_type_catalyst
    ),
    CLAYMORE(
        weaponName = "Claymore",
        resIcon = R.drawable.ic_weapon_type_claymore
    ),
    POLEARM(
        weaponName = "Polearm",
        resIcon = R.drawable.ic_weapon_type_polearm
    ),
    SWORD(
        weaponName = "Sword",
        resIcon = R.drawable.ic_weapon_type_sword
    ),


}