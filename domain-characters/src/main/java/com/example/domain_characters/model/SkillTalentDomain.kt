package com.example.domain_characters.model

data class SkillTalentDomain(
    val description: String,
    val name: String,
    val type: String,
    val upgrades: List<Upgrades>,
    val unlock: String
)