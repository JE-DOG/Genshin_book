package com.example.domain.characters.usecase

import com.example.domain.characters.model.CharacterDomain
import com.example.domain.characters.repository.CharactersRepository
import javax.inject.Inject

class IsCharacterInTheDatabaseUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
){

    suspend fun execute(character: CharacterDomain): Boolean{
        val result = charactersRepository.isCharacterInTheDataBase(character)
        return result
    }

}