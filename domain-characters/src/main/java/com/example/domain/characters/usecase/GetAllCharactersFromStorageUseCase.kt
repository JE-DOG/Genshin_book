package com.example.domain.characters.usecase

import com.example.domain.characters.model.CharacterDomain
import com.example.domain.characters.repository.CharactersRepository

class GetAllCharactersFromStorageUseCase(
    private val charactersRepository: CharactersRepository
) {

    suspend fun execute(): MutableList<CharacterDomain>{
        val result = charactersRepository.getAllFromStorage().toMutableList()
        return result
    }

}