package com.example.genshinbook.data.storage.model

import com.example.genshinbook.presentaion.model.character.Constellation
import com.example.genshinbook.presentaion.model.character.PassiveTalent
import com.example.genshinbook.presentaion.model.character.SkillTalent
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

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

}