package com.example.genshinbook.domain.usecase.characters

import com.example.genshinbook.domain.repository.characters.CharactersRepository
import com.example.genshinbook.presentaion.model.character.Character

class GetAllCharactersFromStorageUseCase(
    private val charactersRepository: CharactersRepository
) {

    suspend fun execute(): MutableList<Character>{
        val result = charactersRepository.getAllFromStorage().map { Character.fromDomain(it).apply { isDownload = true } }.toMutableList()
        return result
    }

}