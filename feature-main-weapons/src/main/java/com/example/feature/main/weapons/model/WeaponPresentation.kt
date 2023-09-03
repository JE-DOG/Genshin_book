package com.example.feature.main.weapons.model

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.feature.main.weapons.data.network.model.WeaponJson
import com.example.feature.main.weapons.domain.model.WeaponDomain

/*{
*    "name": "Akuoumaru",
*    "type": "Claymore",
*    "rarity": 4,
*    "baseAttack": 42,
*    "subStat": "ATK",
*    "passiveName": "Watatsumi Wavewalker",
*    "passiveDesc": "For every point of the entire party's combined maximum Energy capacity, the Elemental Burst DMG of the character equipping this weapon is increased by 0.12/0.15/0.18/0.21/0.24%. A maximum of 40/50/60/70/80% increased Elemental Burst DMG can be achieved this way.",
*    "location": "Gacha",
*    "ascensionMaterial": "distantant-sea"
*}
*
**/
@Immutable
data class WeaponPresentation(
    @Stable
    val name: String,
    @Stable
    val ascensionMaterial: String?,
    @Stable
    val baseAttack: Int,
    @Stable
    val location: String,
    @Stable
    val passiveDesc: String,
    @Stable
    val passiveName: String,
    @Stable
    val rarity: Int,
    @Stable
    val subStat: String,
    @Stable
    val type: String,
    var isDownloaded: Boolean = false
){

    fun toDomain() = WeaponDomain(
        name = name,
        ascensionMaterial = ascensionMaterial,
        baseAttack = baseAttack,
        location = location,
        passiveDesc = passiveDesc,
        passiveName = passiveName,
        rarity = rarity,
        subStat = subStat,
        type = type
    )

    companion object {

        fun fromDomain(
            weaponDomain: WeaponDomain
        ): WeaponPresentation {

            weaponDomain.run {

                return WeaponPresentation(
                    name = name,
                    ascensionMaterial = ascensionMaterial,
                    baseAttack = baseAttack,
                    location = location,
                    passiveDesc = passiveDesc,
                    passiveName = passiveName,
                    rarity = rarity,
                    subStat = subStat,
                    type = type,
                    isDownloaded = isDownloaded
                )

            }

        }

    }
}