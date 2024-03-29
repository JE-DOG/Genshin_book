package com.example.data.characters.storage.model

import com.example.domain.characters.model.UpgradesDomain
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class UpgradesStorage: RealmObject {

    @PrimaryKey
    var id: ObjectId = ObjectId()
    var name: String = ""
    var value: String = ""

    fun toDomain(): UpgradesDomain {

        return UpgradesDomain(
            name = name,
            value = value
        )

    }

    companion object {

        fun fromDomain(
            upgradesDomain: UpgradesDomain
        ): UpgradesStorage {

            upgradesDomain.run {
                return UpgradesStorage().apply {
                    name = this@run.name
                    value = this@run.value
                }
            }

        }

    }
}