package com.example.data.characters.storage.model

import com.example.domain.characters.model.SkillTalentDomain
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.ext.toRealmList
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class SkillTalentStorage: RealmObject {

    @PrimaryKey
    var id: ObjectId= ObjectId()
    var description: String = ""
    var name: String = ""
    var type: String = ""
    var upgrades: RealmList<UpgradesStorage> = realmListOf(UpgradesStorage())
    var unlock: String = ""
    
    fun toDomain(): SkillTalentDomain {

        return SkillTalentDomain(
            description = description,
            name = name,
            type = type,
            upgrades = upgrades.map {
                it.toDomain()
            },
            unlock = unlock
        )

    }

    companion object {

        fun fromDomain(
            skillTalentDomain: SkillTalentDomain
        ): SkillTalentStorage {

            skillTalentDomain.run { 

                return SkillTalentStorage().apply {
                    description = this@run.description
                    name = this@run.name
                    type = this@run.type
                    upgrades = this@run.upgrades.map {
                        UpgradesStorage.fromDomain(it)
                    }.toRealmList()
                    unlock = this@run.unlock
                }
                    
                

            }

        }

    }
}