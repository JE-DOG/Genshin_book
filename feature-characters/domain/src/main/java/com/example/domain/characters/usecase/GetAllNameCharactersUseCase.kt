package com.example.domain.characters.usecase

import com.example.domain.characters.repository.CharactersRepository

class GetAllNameCharactersUseCase(
    private val charactersRepository: CharactersRepository
) {

    suspend fun execute(): List<String>{
        val result = charactersRepository.getAllName()
        return result
    }

}