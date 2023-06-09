package com.example.genshinbook.presentaion.model.character

import com.example.genshinbook.domain.model.characters.CharacterDomain
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

    //todo add parcelize for fix bag ( android.os.BadParcelableException: Parcelable encountered IOException writing serializable object (name = com.example.genshinbook.presentaion.screen.detail.CharacterDetailScreen) )


    companion object{

        fun fromDomain(
            characterDomain: CharacterDomain
        ): Character {

            characterDomain.run {

                return Character(
                    affiliation,
                    birthday,
                    constellation,
                    constellations,
                    description,
                    name,
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

