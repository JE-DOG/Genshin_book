package com.example.genshinbook.domain.model.characters

import com.example.genshinbook.data.network.model.character.CharacterNetwork
import com.example.genshinbook.presentaion.model.character.Constellation
import com.example.genshinbook.presentaion.model.character.PassiveTalent
import com.example.genshinbook.presentaion.model.character.SkillTalent
import com.example.genshinbook.presentaion.model.character.Character

data class CharacterDomain(
    val affiliation: String,
    val birthday: String,
    val constellation: String,
    val constellations: List<Constellation>,
    val description: String,
    val name: String,
    val nation: String,
    val passiveTalents: List<PassiveTalent>,
    val rarity: Int,
    val skillTalents: List<SkillTalent>,
    val title: String,
    val vision: String,
    val vision_key: String,
    val weapon: String,
    val weapon_type: String
) {



    companion object{

        fun fromNetwork(
            characterNetwork: CharacterNetwork
        ): CharacterDomain{

            characterNetwork.run {

                return CharacterDomain(
                    affiliation, birthday, constellation, constellations, description, name, nation, passiveTalents, rarity, skillTalents, title, vision, vision_key, weapon, weapon_type
                )

            }

        }

        fun fromPresentation(
            character: Character
        ): CharacterDomain{

            character.run {

                return CharacterDomain(
                    affiliation, birthday, constellation, constellations, description, name, nation, passiveTalents, rarity, skillTalents, title, vision, vision_key, weapon, weapon_type
                )

            }

        }

    }
}