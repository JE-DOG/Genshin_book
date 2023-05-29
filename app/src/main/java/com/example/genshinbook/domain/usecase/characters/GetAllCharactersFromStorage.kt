package com.example.genshinbook.domain.usecase.characters

import com.example.genshinbook.domain.repository.characters.CharactersRepository
import com.example.genshinbook.presentaion.model.character.Character

class GetAllCharactersFromStorage(
    private val charactersRepository: CharactersRepository
) {

    suspend fun execute(): List<Character>{
        val result = charactersRepository.getAllFromStorage().map { Character.fromDomain(it).apply { isDownload = true } }
        return result
    }

}