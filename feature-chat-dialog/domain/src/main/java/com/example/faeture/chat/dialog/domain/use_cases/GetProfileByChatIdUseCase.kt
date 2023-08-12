package com.example.faeture.chat.dialog.domain.use_cases

import com.example.add.chat.domain.model.ProfileDomain
import com.example.faeture.chat.dialog.domain.ChatDialogRepository
import kotlinx.coroutines.flow.Flow

class GetProfileByChatIdUseCase(
    private val chatDialogRepository: ChatDialogRepository
) {

    fun execute(userId: String): Flow<ProfileDomain> {
        val result = chatDialogRepository.getProfileByChatId(userId)
        return result
    }

}