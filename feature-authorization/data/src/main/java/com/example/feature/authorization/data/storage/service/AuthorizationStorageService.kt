package com.example.feature.authorization.data.storage.service

interface AuthorizationStorageService {

    suspend fun saveUserId(userId: String)

}