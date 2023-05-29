package com.example.genshinbook.domain.repository.characters

import com.example.genshinbook.domain.model.characters.CharacterDomain

interface CharactersRepository {

    suspend fun getAllName(): List<String>

    suspend fun getCurrentInfo(characterName: String): CharacterDomain

    suspend fun getAllInfo(): List<CharacterDomain>

    suspend fun removeFromStorage(characterDomain: CharacterDomain)

    suspend fun addToStorage(characterDomain: CharacterDomain)

    suspend fun getAllFromStorage(): List<CharacterDomain>

    suspend fun isCharacterInTheDataBase(character: CharacterDomain): Boolean

}