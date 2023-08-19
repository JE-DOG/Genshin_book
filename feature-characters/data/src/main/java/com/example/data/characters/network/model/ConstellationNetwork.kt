package com.example.data.characters.network.model

import com.example.domain.characters.model.ConstellationDomain

data class ConstellationNetwork(
    val description: String,
    val level: Int,
    val name: String,
    val unlock: String
) {
    fun toDomain(): ConstellationDomain {

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
        ): ConstellationNetwork {
            constellationDomain.run {

                return ConstellationNetwork(
                    description = description,
                    level = level,
                    name = name,
                    unlock = unlock,
                )


            }
        }

    }
}