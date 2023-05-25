package com.example.genshinbook.domain.usecase.characters

import com.example.genshinbook.domain.repository.characters.CharactersRepository

class GetAllNameCharactersUseCase(
    private val charactersRepository: CharactersRepository
) {

    suspend fun execute(): List<String>{
        val result = charactersRepository.getAllName()
        return result
    }

}