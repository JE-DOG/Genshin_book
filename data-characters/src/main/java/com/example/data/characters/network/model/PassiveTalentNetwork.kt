package com.example.data.characters.network.model

import com.example.domain.characters.model.PassiveTalentDomain

data class PassiveTalentNetwork(
    val description: String,
    val level: Int,
    val name: String,
    val unlock: String
){
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
        ): PassiveTalentNetwork {
            passiveTalentDomain.run {

                return PassiveTalentNetwork(
                    description = description,
                    level = level,
                    name = name,
                    unlock = unlock,
                )

            }
        }

    }
}