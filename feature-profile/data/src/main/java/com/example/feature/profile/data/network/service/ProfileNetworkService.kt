package com.example.feature.profile.data.network.service

import com.example.feature.add.chat.data.network.model.ProfileJson
import kotlinx.coroutines.flow.Flow

interface ProfileNetworkService {

    fun get(): Flow<ProfileJson>

}