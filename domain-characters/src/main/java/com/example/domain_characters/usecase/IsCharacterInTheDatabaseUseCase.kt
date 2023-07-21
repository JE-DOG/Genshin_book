package com.example.domain_characters.usecase

import com.example.domain_characters.model.CharacterDomain
import com.example.domain_characters.repository.CharactersRepository

class IsCharacterInTheDatabaseUseCase(
    private val charactersRepository: CharactersRepository
){

    suspend fun execute(character: CharacterDomain): Boolean{
        val result = charactersRepository.isCharacterInTheDataBase(character)
        return result
    }

}