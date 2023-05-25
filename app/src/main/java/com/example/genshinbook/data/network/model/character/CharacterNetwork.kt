package com.example.genshinbook.data.network.model.character

import com.example.genshinbook.domain.model.characters.CharacterDomain
import com.example.genshinbook.presentaion.model.character.Constellation
import com.example.genshinbook.presentaion.model.character.PassiveTalent
import com.example.genshinbook.presentaion.model.character.SkillTalent

data class CharacterNetwork(
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
){

    companion object{
        fun fromDomain(
            characterDomain: CharacterDomain
        ): CharacterNetwork {

            characterDomain.run {

                return CharacterNetwork(
                    affiliation, birthday, constellation, constellations, description, name, nation, passiveTalents, rarity, skillTalents, title, vision, vision_key, weapon, weapon_type
                )

            }

        }

    }
}