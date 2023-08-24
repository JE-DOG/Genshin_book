package com.example.data.characters.repository

import com.example.data.characters.network.repository.CharactersNetworkService
import com.example.data.characters.storage.model.CharacterStorage
import com.example.data.characters.storage.repository.CharacterStorageService
import com.example.domain.characters.model.CharacterDomain
import com.example.domain.characters.repository.CharactersRepository

class CharactersRepositoryImpl(
    private val charactersNetwork: CharactersNetworkService,
    private val characterStorageRepository: CharacterStorageService
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