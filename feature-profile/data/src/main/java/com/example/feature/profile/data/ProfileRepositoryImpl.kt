package com.example.feature.profile.data

import com.example.add.chat.domain.model.ProfileDomain
import com.example.feature.profile.data.network.service.ProfileNetworkService
import com.example.feature.profile.domain.ProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProfileRepositoryImpl(
    private val networkService: ProfileNetworkService
): ProfileRepository {

    override fun get(): Flow<ProfileDomain> {
        val result = networkService.get()
        return result
            .map {
                it.toDomain()
            }
    }
}