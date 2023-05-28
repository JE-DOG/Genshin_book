package com.example.genshinbook.domain.repository.characters

import com.example.genshinbook.domain.model.characters.CharacterDomain

interface CharactersRepository {

    suspend fun getAllName(): List<String>

    suspend fun getCurrentInfo(characterName: String): CharacterDomain

    suspend fun getAllInfo(): List<CharacterDomain>

}