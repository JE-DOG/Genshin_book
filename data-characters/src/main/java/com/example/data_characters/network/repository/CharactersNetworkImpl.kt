package com.example.data_characters.network.repository

import com.example.data_characters.network.api.CharactersApi
import com.example.data_characters.network.model.CharacterNetwork
import javax.inject.Inject

class CharactersNetworkImpl @Inject constructor(
    private val api: CharactersApi
) : CharactersNetwork {

    override suspend fun getAllName(): List<String> {
        val result = api.getAllName()
        return result.body()!!
    }

    override suspend fun getCurrentInfo(characterName: String): CharacterNetwork {
        val result = api.getCurrentInfo(characterName)
        return result.body()!!
    }

    override suspend fun getAllInfo(): List<CharacterNetwork> {
        val result = api.getAllInfo()
        return result.body()!!
    }



}