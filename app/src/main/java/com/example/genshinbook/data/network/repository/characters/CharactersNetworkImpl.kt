package com.example.genshinbook.data.network.repository.characters

import com.example.genshinbook.core.ext.log
import com.example.genshinbook.data.network.api.CharactersApi
import com.example.genshinbook.data.network.model.character.CharacterNetwork
import javax.inject.Inject

class CharactersNetworkImpl @Inject constructor(
    private val api: CharactersApi
) : CharactersNetwork {

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