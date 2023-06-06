package com.example.genshinbook.presentaion.model.character

import java.io.Serializable

data class PassiveTalent(
    val description: String,
    val level: Int,
    val name: String,
    val unlock: String
) : Serializable