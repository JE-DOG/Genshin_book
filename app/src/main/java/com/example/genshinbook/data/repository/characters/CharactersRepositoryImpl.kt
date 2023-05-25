package com.example.genshinbook.data.repository.characters

import com.example.genshinbook.data.network.repository.characters.CharactersNetwork
import com.example.genshinbook.domain.model.characters.CharacterDomain
import com.example.genshinbook.domain.repository.characters.CharactersRepository

class CharactersRepositoryImpl(
    private val charactersNetwork: CharactersNetwork
) : CharactersRepository {

    override suspend fun getAllName(): List<String> {
        val result = charactersNetwork.getAllName()
        return result
    }

    override suspend fun getCurrentInfo(characterName: String): CharacterDomain{
        val result = charactersNetwork.getCurrentInfo(characterName)
        return CharacterDomain.fromNetwork(result)
    }

    override suspend fun getAllInfo(): List<CharacterDomain> {
        val result = charactersNetwork.getAllInfo()
        return result.map { CharacterDomain.fromNetwork(it) }
    }

}