package com.example.genshinbook.data.network.repository.characters

import com.example.genshinbook.core.ext.log
import com.example.genshinbook.data.network.Network
import com.example.genshinbook.data.network.model.character.CharacterNetwork

class CharactersNetworkImpl : CharactersNetwork {

    private val api = Network.charactersApi
    private val logName = "CharacterApiTest"

    override suspend fun getAllName(): List<String> {
        val result = api.getAllName()
        result.log(logName)
        return result.body()!!
    }

    override suspend fun getCurrentInfo(characterName: String): CharacterNetwork {
        val result = api.getCurrentInfo(characterName)
        result.log(logName)
        return result.body()!!
    }

    override suspend fun getAllInfo(): List<CharacterNetwork> {
        val result = api.getAllInfo()
        result.log(logName)
        return result.body()!!
    }



}