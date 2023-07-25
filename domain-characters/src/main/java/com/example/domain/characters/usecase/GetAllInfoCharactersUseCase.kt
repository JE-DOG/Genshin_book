package com.example.domain.characters.usecase

import com.example.domain.characters.model.CharacterDomain
import com.example.domain.characters.repository.CharactersRepository

class GetAllInfoCharactersUseCase(
    private val charactersRepository: CharactersRepository
) {

    suspend fun execute(): List<CharacterDomain>{
        val result = charactersRepository.getAllInfo()
        return result
    }

}