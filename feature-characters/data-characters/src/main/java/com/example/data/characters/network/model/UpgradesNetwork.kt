package com.example.data.characters.network.model

import com.example.domain.characters.model.UpgradesDomain

data class UpgradesNetwork(
    val name: String,
    val value: String
){
    fun toDomain(): UpgradesDomain {

        return UpgradesDomain(
            name = name,
            value = value
        )

    }

    companion object {

        fun fromDomain(
            upgradesDomain: UpgradesDomain
        ): UpgradesNetwork {

            upgradesDomain.run {
                return UpgradesNetwork(
                    name = name,
                    value = value,
                )
            }

        }

    }
}