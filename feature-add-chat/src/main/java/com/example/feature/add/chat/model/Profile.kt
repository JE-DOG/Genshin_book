package com.example.feature.add.chat.model

import com.example.add.chat.domain.model.ProfileDomain
import com.example.feature.add.chat.data.network.model.ProfileJson

data class Profile(
    val id: String,
    val createdAt: String,
    val fullName: String,
    val avatar: String
) {


    companion object {

        fun fromJson(
            profileJson: ProfileJson
        ): Profile {
            profileJson.run {

                return Profile(
                    id = id,
                    createdAt = created_at,
                    fullName = fullname,
                    avatar = avatar
                )

            }
        }

        fun fromDomain(
            profileDomain: ProfileDomain
        ): Profile {
            profileDomain.run {

                return Profile(
                    id = id,
                    createdAt = createdAt,
                    fullName = fullName,
                    avatar = avatar
                )

            }
        }

    }
}