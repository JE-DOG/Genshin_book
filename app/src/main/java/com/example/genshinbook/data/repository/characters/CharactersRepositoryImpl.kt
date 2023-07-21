package com.example.genshinbook.data.repository.characters

import com.example.genshinbook.data.network.repository.characters.CharactersNetwork
import com.example.genshinbook.data.storage.model.CharacterStorage
import com.example.genshinbook.data.storage.repository.character.CharacterStorageRepository
import com.example.domain_characters.domain.model.characters.CharacterDomain
import com.example.domain_characters.domain.repository.characters.CharactersRepository

class CharactersRepositoryImpl(
    private val charactersNetwork: CharactersNetwork,
    private val characterStorageRepository: CharacterStorageRepository
) : com.example.domain_characters.domain.repository.characters.CharactersRepository {

    override suspend fun getAllName(): List<String> {
        val result = charactersNetwork.getAllName()
        return result
    }

    override suspend fun getCurrentInfo(characterName: String): com.example.domain_characters.domain.model.characters.CharacterDomain {
        val result = charactersNetwork.getCurrentInfo(characterName)
        return com.example.domain_characters.domain.model.characters.CharacterDomain.fromNetwork(result)
    }

    override suspend fun getAllInfo(): List<com.example.domain_characters.domain.model.characters.CharacterDomain> {
        val result = charactersNetwork.getAllInfo().map { com.example.domain_characters.domain.model.characters.CharacterDomain.fromNetwork(it) }

        return result
    }

    override suspend fun removeFromStorage(characterDomain: com.example.domain_characters.domain.model.characters.CharacterDomain) {
        characterStorageRepository.remove(CharacterStorage.fromDomain(characterDomain))
    }

    override suspend fun addToStorage(characterDomain: com.example.domain_characters.domain.model.characters.CharacterDomain) {
        characterStorageRepository.add(CharacterStorage.fromDomain(characterDomain))
    }

    override suspend fun getAllFromStorage(): List<com.example.domain_characters.domain.model.characters.CharacterDomain> {
        val result = characterStorageRepository.getAll().map { com.example.domain_characters.domain.model.characters.CharacterDomain.fromStorage(it) }
        return result
    }

    override suspend fun isCharacterInTheDataBase(character: com.example.domain_characters.domain.model.characters.CharacterDomain): Boolean {
        val result = characterStorageRepository.isInTheDataBase(CharacterStorage.fromDomain(character))
        return result
    }

}