package com.example.feature.authorization.domain.use_cases

import com.example.feature.authorization.domain.AuthorizationRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val authorizationRepository: AuthorizationRepository
) {

    suspend fun execute(
        email: String,
        password: String,
        fullname: String,
        avatar: String
    ) {
        authorizationRepository.signUp(
            email = email,
            password = password,
            fullname = fullname,
            avatar = avatar
        )
    }

}