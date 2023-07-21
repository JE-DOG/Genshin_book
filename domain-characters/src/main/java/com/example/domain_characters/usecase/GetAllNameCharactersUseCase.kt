package com.example.domain_characters.usecase

import com.example.domain_characters.repository.CharactersRepository

class GetAllNameCharactersUseCase(
    private val charactersRepository: CharactersRepository
) {

    suspend fun execute(): List<String>{
        val result = charactersRepository.getAllName()
        return result
    }

}