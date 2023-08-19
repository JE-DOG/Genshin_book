package com.example.feature.profile.domain

import com.example.add.chat.domain.model.ProfileDomain
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {

    fun get(): Flow<ProfileDomain>

}