package com.example.feature.authorization.domain.use_cases

import com.example.feature.authorization.domain.AuthorizationRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val authorizationRepository: AuthorizationRepository
) {

    suspend fun signIn(
        email: String,
        password: String
    ) {
        authorizationRepository.signIn(
            email = email,
            password = password
        )
    }

}