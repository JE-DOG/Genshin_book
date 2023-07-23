package com.example.data_characters.storage.model

import com.example.domain_characters.model.PassiveTalentDomain
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class PassiveTalentStorage: RealmObject {

    @PrimaryKey
    var id: ObjectId = ObjectId()
    var description: String = ""
    var level: Int = 0
    var name: String = ""
    var unlock: String = ""

    fun toDomain():PassiveTalentDomain {

        return PassiveTalentDomain(
            description = description,
            level = level,
            name = name,
            unlock = unlock
        )

    }

    companion object {

        fun fromDomain(
            passiveTalentDomain: PassiveTalentDomain
        ): PassiveTalentStorage {
            passiveTalentDomain.run {

                return PassiveTalentStorage().apply {
                    description = this@run.description
                    level = this@run.level
                    name = this@run.name
                    unlock = this@run.unlock
                }

            }
        }

    }
}