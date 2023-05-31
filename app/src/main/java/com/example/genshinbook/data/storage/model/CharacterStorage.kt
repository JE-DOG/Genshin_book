package com.example.genshinbook.data.storage.model

import com.example.genshinbook.domain.model.characters.CharacterDomain
import com.example.genshinbook.presentaion.model.character.Constellation
import com.example.genshinbook.presentaion.model.character.PassiveTalent
import com.example.genshinbook.presentaion.model.character.SkillTalent
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId
import com.example.genshinbook.presentaion.model.character.Character

class CharacterStorage: RealmObject {

    @PrimaryKey
    var id: ObjectId = ObjectId()
    var name: String = ""
    var affiliation: String = ""
    var birthday: String? = null
    var constellation: String = ""
    var constellations: List<Constellation> = emptyList()
    var description: String = ""
    var nation: String = ""
    var passiveTalents: List<PassiveTalent> = emptyList()
    var rarity: Int = 0
    var skillTalents: List<SkillTalent> = emptyList()
    var title: String? = null
    var vision: String = ""
    var vision_key: String = ""
    var weapon: String = ""
    var weapon_type: String = ""

    companion object {
        fun fromDomain(
            characterDomain: CharacterDomain
        ): CharacterStorage {

            return CharacterStorage().apply {
                name  = characterDomain.name
                affiliation = characterDomain.affiliation
                birthday = characterDomain.birthday
                constellation = characterDomain.constellation
                constellations = characterDomain.constellations
                description = characterDomain.description
                nation = characterDomain.nation
                passiveTalents = characterDomain.passiveTalents
                rarity = characterDomain.rarity
                skillTalents = characterDomain.skillTalents
                title = characterDomain.title
                vision = characterDomain.vision
                vision_key = characterDomain.vision_key
                weapon = characterDomain.weapon
                weapon_type = characterDomain.weapon_type
            }


        }

    }

}

