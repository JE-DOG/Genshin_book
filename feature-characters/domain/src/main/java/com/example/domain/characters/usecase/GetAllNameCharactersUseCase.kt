package com.example.domain.characters.usecase

import com.example.domain.characters.repository.CharactersRepository
import javax.inject.Inject

class GetAllNameCharactersUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {

    suspend fun execute(): List<String>{
        val result = charactersRepository.getAllName()
        return result
    }

}