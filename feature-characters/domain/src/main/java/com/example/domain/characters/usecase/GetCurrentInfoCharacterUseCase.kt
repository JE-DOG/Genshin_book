package com.example.domain.characters.usecase

import com.example.domain.characters.model.CharacterDomain
import com.example.domain.characters.repository.CharactersRepository
import javax.inject.Inject

class GetCurrentInfoCharacterUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {

    suspend fun execute(characterName: String): CharacterDomain {
        val result = charactersRepository.getCurrentInfo(characterName)
        return result
    }

}