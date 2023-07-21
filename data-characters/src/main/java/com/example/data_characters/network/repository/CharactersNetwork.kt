package com.example.data_characters.network.repository

import com.example.data_characters.network.model.CharacterNetwork

interface CharactersNetwork {

    suspend fun getAllName(): List<String>

    suspend fun getCurrentInfo(characterName: String): CharacterNetwork

    suspend fun getAllInfo(): List<CharacterNetwork>

}