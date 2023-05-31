package com.example.genshinbook.domain.usecase.characters

import com.example.genshinbook.domain.model.characters.CharacterDomain
import com.example.genshinbook.domain.repository.characters.CharactersRepository
import com.example.genshinbook.presentaion.model.character.Character

class AddCharacterToStorageUseCase(
    private val charactersRepository: CharactersRepository
) {

    suspend fun execute(character: Character){
        charactersRepository.addToStorage(CharacterDomain.fromPresentation(character))
    }

}