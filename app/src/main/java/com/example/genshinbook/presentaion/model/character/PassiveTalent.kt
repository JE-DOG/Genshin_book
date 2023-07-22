package com.example.genshinbook.presentaion.model.character

import com.example.domain_characters.model.ConstellationDomain
import com.example.domain_characters.model.PassiveTalentDomain
import java.io.Serializable

data class PassiveTalent(
    val description: String,
    val level: Int,
    val name: String,
    val unlock: String
) : Serializable {


    fun toDomain(): PassiveTalentDomain {
        return PassiveTalentDomain(
            description = description,
            level = level,
            name = name,
            unlock = unlock
        )
    }

    companion object {

        fun fromDomain(
            passiveTalentDomain: PassiveTalentDomain
        ): PassiveTalent {

            passiveTalentDomain.run {
                return PassiveTalent(
                    description = description,
                    level = level,
                    name = name,
                    unlock = unlock
                )
            }

        }

    }

}