package com.example.data_characters.storage.model

import com.example.domain_characters.model.CharacterDomain
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.ext.toRealmList
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class CharacterStorage: RealmObject {

    @PrimaryKey
    val id: ObjectId = ObjectId()
    var name: String = ""
    var affiliation: String = ""
    var birthday: String? = null
    var constellation: String = ""
    var constellations: RealmList<ConstellationStorage> = realmListOf()
    var description: String = ""
    var nation: String = ""
    var passiveTalents: RealmList<PassiveTalentStorage> = realmListOf()
    var rarity: Int = 0
    var skillTalents: RealmList<SkillTalentStorage> = realmListOf()
    var title: String? = null
    var vision: String = ""
    var vision_key: String = ""
    var weapon: String = ""
    var weapon_type: String = ""

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
            weapon_type = weapon_type
        )

    }

    companion object {
        fun fromDomain(
            characterDomain: CharacterDomain
        ): CharacterStorage {

            return CharacterStorage().apply {
                name  = characterDomain.name
                affiliation = characterDomain.affiliation
                birthday = characterDomain.birthday
                constellation = characterDomain.constellation
                constellations = characterDomain.constellations.map {
                    ConstellationStorage.fromDomain(it)
                }.toRealmList()
                description = characterDomain.description
                nation = characterDomain.nation
                passiveTalents = characterDomain.passiveTalents.map {
                    PassiveTalentStorage.fromDomain(it)
                }.toRealmList()
                rarity = characterDomain.rarity
                skillTalents = characterDomain.skillTalents.map {
                    SkillTalentStorage.fromDomain(it)
                }.toRealmList()
                title = characterDomain.title
                vision = characterDomain.vision
                vision_key = characterDomain.vision_key
                weapon = characterDomain.weapon
                weapon_type = characterDomain.weapon_type
            }


        }

    }

}

