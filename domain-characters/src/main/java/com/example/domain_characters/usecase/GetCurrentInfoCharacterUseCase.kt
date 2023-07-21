package com.example.domain_characters.usecase

import com.example.domain_characters.model.CharacterDomain
import com.example.domain_characters.repository.CharactersRepository

class GetCurrentInfoCharacterUseCase(
    private val charactersRepository: CharactersRepository
) {

    suspend fun execute(characterName: String): CharacterDomain {
        val result = charactersRepository.getCurrentInfo(characterName)
        return result
    }

}