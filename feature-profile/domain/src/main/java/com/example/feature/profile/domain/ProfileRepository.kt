package com.example.feature.profile.domain

import com.example.add.chat.domain.model.ProfileDomain

interface ProfileRepository {

    fun get(): ProfileDomain

}