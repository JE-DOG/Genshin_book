package com.example.genshinbook.domain.model.characters

import android.util.Log
import com.example.genshinbook.core.ext.isNull
import com.example.genshinbook.data.network.model.character.CharacterNetwork
import com.example.genshinbook.presentaion.model.character.Constellation
import com.example.genshinbook.presentaion.model.character.PassiveTalent
import com.example.genshinbook.presentaion.model.character.SkillTalent
import com.example.genshinbook.presentaion.model.character.Character

data class CharacterDomain(
    val name: String,
    val affiliation: String,
    val birthday: String?,
    val constellation: String,
    val constellations: List<Constellation>,
    val description: String,
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

        fun fromNetwork(
            characterNetwork: CharacterNetwork
        ): CharacterDomain{


            characterNetwork.run {

                return CharacterDomain(
                    name,
                    affiliation,
                    birthday,
                    constellation,
                    constellations,
                    description,
                    nation,
                    passiveTalents,
                    rarity,
                    skillTalents,
                    title,
                    vision,
                    vision_key,
                    weapon,
                    weapon_type
                )

            }

        }

        fun fromPresentation(
            character: Character
        ): CharacterDomain{

            character.run {

                return CharacterDomain(
                    name,
                    affiliation,
                    birthday,
                    constellation,
                    constellations,
                    description,
                    nation,
                    passiveTalents,
                    rarity,
                    skillTalents,
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