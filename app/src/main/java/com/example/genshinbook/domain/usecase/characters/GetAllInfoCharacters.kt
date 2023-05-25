package com.example.genshinbook.domain.usecase.characters

import com.example.genshinbook.domain.repository.characters.CharactersRepository
import com.example.genshinbook.presentaion.model.character.Character

class GetAllInfoCharacters(
    private val charactersRepository: CharactersRepository
) {

    suspend fun execute(): List<Character>{
        val result = charactersRepository.getAllInfo()
        return result.map { Character.fromDomain(it) }
    }

}