package com.example.genshinbook.domain.usecase.characters

import com.example.genshinbook.domain.model.characters.CharacterDomain
import com.example.genshinbook.domain.repository.characters.CharactersRepository
import com.example.genshinbook.presentaion.model.character.Character

class IsCharacterInTheDatabaseUseCase(
    private val charactersRepository: CharactersRepository
){

    suspend fun execute(character: Character): Boolean{
        val result = charactersRepository.isCharacterInTheDataBase(CharacterDomain.fromPresentation(character))
        return result
    }

}