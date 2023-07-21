package com.example.domain_characters.usecase

import com.example.domain_characters.model.CharacterDomain
import com.example.domain_characters.repository.CharactersRepository

class GetAllInfoCharactersUseCase(
    private val charactersRepository: CharactersRepository
) {

    suspend fun execute(): List<CharacterDomain>{
        val result = charactersRepository.getAllInfo()
        return result
    }

}