package com.example.data_characters.repository

import com.example.data_characters.network.repository.CharactersNetwork
import com.example.data_characters.storage.model.CharacterStorage
import com.example.data_characters.storage.repository.CharacterStorageRepository
import com.example.domain_characters.model.CharacterDomain
import com.example.domain_characters.repository.CharactersRepository

class CharactersRepositoryImpl(
    private val charactersNetwork: CharactersNetwork,
    private val characterStorageRepository: CharacterStorageRepository
) : CharactersRepository {

    override suspend fun getAllName(): List<String> {
        val result = charactersNetwork.getAllName()
        return result
    }

    override suspend fun getCurrentInfo(characterName: String): CharacterDomain {
        val result = charactersNetwork.getCurrentInfo(characterName)
        return result.toDomain()
    }

    override suspend fun getAllInfo(): List<CharacterDomain> {
        val result = charactersNetwork.getAllInfo().map { it.toDomain() }

        return result
    }

    override suspend fun removeFromStorage(characterDomain: CharacterDomain) {
        characterStorageRepository.remove(CharacterStorage.fromDomain(characterDomain))
    }

    override suspend fun addToStorage(characterDomain: CharacterDomain) {
        characterStorageRepository.add(CharacterStorage.fromDomain(characterDomain))
    }

    override suspend fun getAllFromStorage(): List<CharacterDomain> {
        val result = characterStorageRepository.getAll().map { it.toDomain() }
        return result
    }

    override suspend fun isCharacterInTheDataBase(character: CharacterDomain): Boolean {
        val result = characterStorageRepository.isInTheDataBase(CharacterStorage.fromDomain(character))
        return result
    }

}