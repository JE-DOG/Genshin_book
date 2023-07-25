package com.example.domain.characters.model

data class SkillTalentDomain(
    val description: String,
    val name: String,
    val type: String,
    val upgrades: List<UpgradesDomain>,
    val unlock: String
)