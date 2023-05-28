package com.example.genshinbook.presentaion.model.character

import com.example.genshinbook.domain.model.characters.CharacterDomain

data class Character(
    val affiliation: String,
    val birthday: String?,
    val constellation: String,
    val constellations: List<Constellation>,
    val description: String,
    val name: String,
    val nation: String,
    val passiveTalents: List<PassiveTalent>,
    val rarity: Int,
    val skillTalents: List<SkillTalent>,
    val title: String?,
    val vision: String,
    val vision_key: String,
    val weapon: String,
    val weapon_type: String
) {

    companion object{

        fun fromDomain(
            characterDomain: CharacterDomain
        ): Character {

            characterDomain.run {

                return Character(
                    affiliation, birthday, constellation, constellations, description, name, nation, passiveTalents, rarity, skillTalents, title, vision, vision_key, weapon, weapon_type
                )

            }

        }

    }


}

