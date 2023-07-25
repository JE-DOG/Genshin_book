package com.example.domain.characters.usecase

import com.example.domain.characters.model.CharacterDomain
import com.example.domain.characters.repository.CharactersRepository

class RemoveCharacterFromStorageUseCase(
    private val charactersRepository: CharactersRepository
) {

    suspend fun execute(character: CharacterDomain){
        charactersRepository.removeFromStorage(character)
    }

}