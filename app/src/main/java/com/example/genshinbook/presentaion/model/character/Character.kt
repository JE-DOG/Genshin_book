package com.example.genshinbook.presentaion.model.character

import com.example.domain_characters.model.CharacterDomain
import java.io.Serializable

data class Character(
    val affiliation: String = "",
    val birthday: String? = null,
    val constellation: String = "",
    val constellations: List<Constellation> = emptyList(),
    val description: String = "",
    val name: String = "",
    val nation: String = "",
    val passiveTalents: List<PassiveTalent> = emptyList(),
    val rarity: Int = 0,
    val skillTalents: List<SkillTalent> = emptyList(),
    val title: String? = null,
    val vision: String  = "",
    val vision_key: String = "",
    val weapon: String = "",
    val weapon_type: String = "",
    var isDownload: Boolean = false
): Serializable {

    fun toDomain(): CharacterDomain {
        return CharacterDomain(
            affiliation = affiliation,
            birthday = birthday,
            constellation = constellation,
            constellations = constellations.map { it.toDomain() },
            description = description,
            name = name,
            nation = nation,
            passiveTalents = passiveTalents.map {
                it.toDomain()
            },
            rarity = rarity,
            skillTalents = skillTalents.map {
                it.toDomain()
            },
            title = title,
            vision = vision,
            vision_key = vision_key,
            weapon = weapon,
            weapon_type = weapon_type
        )
    }

    companion object{

        fun fromDomain(
            characterDomain: CharacterDomain
        ): Character {

            characterDomain.run {

                return Character(
                    affiliation,
                    birthday,
                    constellation,
                    constellations.map {
                        Constellation.fromDomain(it)
                    },
                    description,
                    name,
                    nation,
                    passiveTalents.map {
                        PassiveTalent.fromDomain(it)
                    },
                    rarity,
                    skillTalents.map {
                        SkillTalent.fromDomain(it)
                    },
                    title,
                    vision,
                    vision_key,
                    weapon,
                    weapon_type
                )

            }

        }

    }


}

