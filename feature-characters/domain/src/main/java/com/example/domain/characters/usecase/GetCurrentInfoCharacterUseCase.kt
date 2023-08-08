package com.example.domain.characters.usecase

import com.example.domain.characters.model.CharacterDomain
import com.example.domain.characters.repository.CharactersRepository

class GetCurrentInfoCharacterUseCase(
    private val charactersRepository: CharactersRepository
) {

    suspend fun execute(characterName: String): CharacterDomain {
        val result = charactersRepository.getCurrentInfo(characterName)
        return result
    }

}