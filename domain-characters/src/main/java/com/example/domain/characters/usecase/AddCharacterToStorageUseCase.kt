package com.example.domain.characters.usecase

import com.example.domain.characters.model.CharacterDomain
import com.example.domain.characters.repository.CharactersRepository

class AddCharacterToStorageUseCase(
    private val charactersRepository: CharactersRepository
) {

    suspend fun execute(character: CharacterDomain){
        charactersRepository.addToStorage(character)
    }

}