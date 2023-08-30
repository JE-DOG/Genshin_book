package com.example.feature.main.weapons.domain.model

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

data class WeaponDomain(
    val name: String,
    val ascensionMaterial: String,
    val baseAttack: Int,
    val location: String,
    val passiveDesc: String,
    val passiveName: String,
    val rarity: Int,
    val subStat: String,
    val type: String,
    var isDownloaded: Boolean = false
)