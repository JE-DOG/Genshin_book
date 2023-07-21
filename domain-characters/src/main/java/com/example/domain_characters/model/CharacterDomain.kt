package com.example.domain_characters.model


data class CharacterDomain(
    val name: String,
    val affiliation: String,
    val birthday: String?,
    val constellation: String,
    val constellations: List<ConstellationDomain>,
    val description: String,
    val nation: String,
    val passiveTalents: List<PassiveTalentDomain>,
    val rarity: Int,
    val skillTalents: List<SkillTalentDomain>,
    val title: String?,
    val vision: String,
    val vision_key: String,
    val weapon: String,
    val weapon_type: String
)