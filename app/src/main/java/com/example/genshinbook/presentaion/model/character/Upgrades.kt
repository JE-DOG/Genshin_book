package com.example.genshinbook.presentaion.model.character

import com.example.domain_characters.model.UpgradesDomain
import java.io.Serializable

data class Upgrades(
    val name: String,
    val value: String
): Serializable {

    fun toDomain(): UpgradesDomain {
        return UpgradesDomain(
            name = name,
            value = value
        )
    }

    companion object {

        fun fromDomain(
            upgradesDomain: UpgradesDomain
        ): Upgrades {
            upgradesDomain.run {
                return Upgrades(
                    name = name,
                    value = value
                )
            }
        }

    }

}
