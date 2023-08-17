package com.example.feature.authorization.data

import com.example.feature.authorization.data.network.service.AuthorizationNetworkService
import com.example.feature.authorization.data.storage.service.AuthorizationStorageService
import com.example.feature.authorization.domain.AuthorizationRepository

class AuthorizationRepositoryImpl(
    private val storageService: AuthorizationStorageService,
    private val networkService: AuthorizationNetworkService
): AuthorizationRepository {

    override suspend fun saveUserId(userId: String) {
        storageService.saveUserId(userId)
    }

    override suspend fun signIn(email: String, password: String) {
        val userId = networkService.signIn(
            email = email,
            password = password
        )

        saveUserId(userId)
    }

    override suspend fun signUp(email: String, password: String, fullname: String, avatar: String) {
        networkService.signUp(
            email = email,
            password = password,
            fullname = fullname,
            avatar = avatar
        )
    }
}