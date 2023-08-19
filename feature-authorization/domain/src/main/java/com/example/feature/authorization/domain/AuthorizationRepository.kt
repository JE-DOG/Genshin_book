package com.example.feature.authorization.domain

interface AuthorizationRepository {

    suspend fun saveUserId(userId: String)

    suspend fun signIn(
        email: String,
        password: String
    )

    suspend fun signUp(
        email: String,
        password: String,
        fullname: String,
        avatar: String
    )

}