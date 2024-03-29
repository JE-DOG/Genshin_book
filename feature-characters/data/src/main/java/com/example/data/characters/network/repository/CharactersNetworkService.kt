package com.example.data.characters.network.repository

import com.example.data.characters.network.model.CharacterNetwork

interface CharactersNetworkService {

    suspend fun getAllName(): List<String>

    suspend fun getCurrentInfo(characterName: String): CharacterNetwork

    suspend fun getAllInfo(): List<CharacterNetwork>

}