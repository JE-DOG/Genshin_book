package com.example.genshinbook.data.network.repository.characters

import com.example.genshinbook.data.network.model.character.CharacterNetwork

interface CharactersNetwork {

    suspend fun getAllName(): List<String>

    suspend fun getCurrentInfo(characterName: String): CharacterNetwork

    suspend fun getAllInfo(): List<CharacterNetwork>

}