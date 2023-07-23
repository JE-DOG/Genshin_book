package com.example.data_characters.network.model

import com.example.domain_characters.model.SkillTalentDomain

data class SkillTalentNetwork(
    val description: String = "",
    val name: String = "",
    val type: String = "",
    val upgrades: List<UpgradesNetwork> = emptyList(),
    val unlock: String = ""
){
    fun toDomain(): SkillTalentDomain {

        return SkillTalentDomain(
            description = description,
            name = name,
            type = type,
            upgrades = upgrades.map {
                it.toDomain()
            },
            unlock = unlock
        )

    }

    companion object {

        fun fromDomain(
            skillTalentDomain: SkillTalentDomain
        ): SkillTalentNetwork {

            skillTalentDomain.run {

                return SkillTalentNetwork(
                    description = description,
                    name = name,
                    type = type,
                    upgrades = upgrades.map {
                        UpgradesNetwork.fromDomain(it)
                    },
                    unlock = unlock,
                )



            }

        }

    }
}