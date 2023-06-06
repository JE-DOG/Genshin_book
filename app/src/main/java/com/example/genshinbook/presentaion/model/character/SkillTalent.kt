package com.example.genshinbook.presentaion.model.character

import java.io.Serializable

data class SkillTalent(
    val description: String,
    val name: String,
    val type: String,
    val upgrades: List<Upgrades>,
    val unlock: String
) : Serializable