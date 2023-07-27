package com.example.data.characters.network.model

import com.example.domain.characters.model.CharacterDomain

data class CharacterNetwork(
    val name: String,
    val affiliation: String,
    val birthday: String?,
    val constellation: String,
    val constellations: List<ConstellationNetwork>,
    val description: String,
    val nation: String,
    val passiveTalents: List<PassiveTalentNetwork>,
    val rarity: Int,
    val skillTalents: List<SkillTalentNetwork>,
    val title: String?,
    val vision: String,
    val vision_key: String,
    val weapon: String,
    val weapon_type: String,
    val isDownload: Boolean = false
){
    fun toDomain(): CharacterDomain {

        return CharacterDomain(
            name = name,
            affiliation = affiliation,
            birthday = birthday,
            constellation = constellation,
            constellations = constellations.map {
                it.toDomain()
            },
            description = description,
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
            weapon_type = weapon_type,
            isDownload = isDownload
        )

    }

    companion object {
        fun fromDomain(
            characterDomain: CharacterDomain
        ): CharacterNetwork {

            characterDomain.run {

                return CharacterNetwork(
                    name = name ,
                    affiliation = affiliation,
                    birthday = birthday,
                    constellation = constellation,
                    constellations = constellations.map {
                        ConstellationNetwork.fromDomain(it)
                    },
                    description = description,
                    nation = nation,
                    passiveTalents = passiveTalents.map {
                        PassiveTalentNetwork.fromDomain(it)
                    },
                    rarity = rarity,
                    skillTalents = skillTalents.map {
                        SkillTalentNetwork.fromDomain(it)
                    },
                    title = title,
                    vision = vision,
                    vision_key = vision_key,
                    weapon = weapon,
                    weapon_type = weapon_type,
                    isDownload = isDownload
                )
                
            }


        }

    }
}