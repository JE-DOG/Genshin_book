package com.example.genshinbook.data.storage.model

import com.example.genshinbook.domain.model.characters.CharacterDomain
import com.example.genshinbook.presentaion.model.character.Constellation
import com.example.genshinbook.presentaion.model.character.PassiveTalent
import com.example.genshinbook.presentaion.model.character.SkillTalent
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId
import com.example.genshinbook.presentaion.model.character.Character

data class CharacterStorage(
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
    val weapon_type: String,
    @PrimaryKey
    val id: ObjectId = ObjectId()
): RealmObject{

    companion object{
        fun fromDomain(
            characterDomain: CharacterDomain,
        ): CharacterStorage {

            characterDomain.run {
                return CharacterStorage(
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