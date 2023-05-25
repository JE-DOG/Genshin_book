package com.example.genshinbook.domain.usecase.characters

import com.example.genshinbook.domain.repository.characters.CharactersRepository
import com.example.genshinbook.presentaion.model.character.Character

class GetCurrentInfoCharacterUseCase(
    private val charactersRepository: CharactersRepository
) {

    suspend fun execute(characterName: String): Character{
        val result = charactersRepository.getCurrentInfo(characterName)
        return Character.fromDomain(result)
    }

}