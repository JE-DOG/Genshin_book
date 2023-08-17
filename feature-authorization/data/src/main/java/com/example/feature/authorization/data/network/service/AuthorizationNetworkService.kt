package com.example.feature.authorization.data.network.service

interface AuthorizationNetworkService {

    suspend fun signIn(
        email: String,
        password: String
    ): String

    suspend fun signUp(
        email: String,
        password: String,
        fullname: String,
        avatar: String
    )

}