package com.example.domain.characters.usecase

import com.example.domain.characters.model.CharacterDomain
import com.example.domain.characters.repository.CharactersRepository
import javax.inject.Inject

class AddCharacterToStorageUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {

    suspend fun execute(character: CharacterDomain){
        charactersRepository.addToStorage(character)
    }

}