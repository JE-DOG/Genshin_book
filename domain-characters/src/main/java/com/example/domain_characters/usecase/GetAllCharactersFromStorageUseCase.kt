package com.example.domain_characters.usecase

import com.example.domain_characters.model.CharacterDomain
import com.example.domain_characters.repository.CharactersRepository

class GetAllCharactersFromStorageUseCase(
    private val charactersRepository: CharactersRepository
) {

    suspend fun execute(): MutableList<CharacterDomain>{
        val result = charactersRepository.getAllFromStorage().toMutableList()
        return result
    }

}