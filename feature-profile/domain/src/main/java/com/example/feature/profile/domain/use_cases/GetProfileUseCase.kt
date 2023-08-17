package com.example.feature.profile.domain.use_cases

import com.example.add.chat.domain.model.ProfileDomain
import com.example.feature.profile.domain.ProfileRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {

    fun execute(): Flow<ProfileDomain> {
        val result = profileRepository.get()
        return result
    }

}