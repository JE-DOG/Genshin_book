package com.example.genshinbook.presentaion.model.character

import com.example.domain_characters.model.ConstellationDomain
import com.example.domain_characters.model.SkillTalentDomain
import java.io.Serializable

data class SkillTalent(
    val description: String,
    val name: String,
    val type: String,
    val upgrades: List<Upgrades>,
    val unlock: String
) : Serializable {


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
        ): SkillTalent {

            skillTalentDomain.run {
                return SkillTalent(
                    description = description,
                    name = name,
                    type = type,
                    upgrades = upgrades.map {
                        Upgrades.fromDomain(it)
                    },
                    unlock = unlock
                )
            }

        }

    }


}