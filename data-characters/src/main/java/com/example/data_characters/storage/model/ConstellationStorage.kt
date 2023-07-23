package com.example.data_characters.storage.model

import com.example.domain_characters.model.ConstellationDomain
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class ConstellationStorage: RealmObject {

    @PrimaryKey
    var id: ObjectId = ObjectId()
    var description: String = ""
    var level: Int = 0
    var name: String = ""
    var unlock: String = ""

    fun toDomain(): ConstellationDomain{

        return ConstellationDomain(
            description = description,
            level = level,
            name = name,
            unlock = unlock
        )

    }

    companion object {

        fun fromDomain(
            constellationDomain: ConstellationDomain
        ): ConstellationStorage {
            constellationDomain.run {

                return ConstellationStorage().apply {
                    description = this@run.description
                    level = this@run.level
                    name = this@run.name
                    unlock = this@run.unlock
                }


            }
        }

    }
}