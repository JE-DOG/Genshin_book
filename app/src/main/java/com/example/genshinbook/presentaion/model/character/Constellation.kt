package com.example.genshinbook.presentaion.model.character

import com.example.domain_characters.model.CharacterDomain
import com.example.domain_characters.model.ConstellationDomain
import java.io.Serializable

data class Constellation(
    val description: String,
    val level: Int,
    val name: String,
    val unlock: String
) : Serializable {

    fun toDomain(): ConstellationDomain {
        return ConstellationDomain(
            description = description,
            level = level,
            name = name,
            unlock = unlock
        )
    }

    companion object {

        fun fromDomain(
            constellationDomain: ConstellationDomain
        ): Constellation {

            constellationDomain.run {
                return Constellation(
                    description = description,
                    level = level,
                    name = name,
                    unlock = unlock
                )
            }

        }

    }

}