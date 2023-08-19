package com.example.domain.characters.model


data class CharacterDomain(
    val affiliation: String = "",
    val birthday: String? = null,
    val constellation: String = "",
    val constellations: List<ConstellationDomain> = emptyList(),
    val description: String = "",
    val name: String = "",
    val nation: String = "",
    val passiveTalents: List<PassiveTalentDomain> = emptyList(),
    val rarity: Int = 0,
    val skillTalents: List<SkillTalentDomain> = emptyList(),
    val title: String? = null,
    val vision: String  = "",
    val vision_key: String = "",
    val weapon: String = "",
    val weapon_type: String = "",
    var isDownload: Boolean = false
)