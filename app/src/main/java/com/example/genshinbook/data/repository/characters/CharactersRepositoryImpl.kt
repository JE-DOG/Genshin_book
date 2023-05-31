package com.example.genshinbook.data.repository.characters

import android.util.Log
import com.example.genshinbook.data.network.repository.characters.CharactersNetwork
import com.example.genshinbook.data.storage.model.CharacterStorage
import com.example.genshinbook.data.storage.repository.character.CharacterStorageRepository
import com.example.genshinbook.domain.model.characters.CharacterDomain
import com.example.genshinbook.domain.repository.characters.CharactersRepository

class CharactersRepositoryImpl(
    private val charactersNetwork: CharactersNetwork,
    private val characterStorageRepository: CharacterStorageRepository
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
        val result = charactersNetwork.getAllInfo().map { CharacterDomain.fromNetwork(it) }

        return result
    }

    override suspend fun removeFromStorage(characterDomain: CharacterDomain) {
        characterStorageRepository.remove(CharacterStorage.fromDomain(characterDomain))
    }

    override suspend fun addToStorage(characterDomain: CharacterDomain) {
        characterStorageRepository.add(CharacterStorage.fromDomain(characterDomain))
    }

    override suspend fun getAllFromStorage(): List<CharacterDomain> {
        val result = characterStorageRepository.getAll().map { CharacterDomain.fromStorage(it) }
        return result
    }

    override suspend fun isCharacterInTheDataBase(character: CharacterDomain): Boolean {
        val result = characterStorageRepository.isInTheDataBase(CharacterStorage.fromDomain(character))
        return result
    }

}