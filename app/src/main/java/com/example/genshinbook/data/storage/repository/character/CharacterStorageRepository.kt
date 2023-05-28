package com.example.genshinbook.data.storage.repository.character

import com.example.genshinbook.data.storage.model.CharacterStorage

interface CharacterStorageRepository {

    suspend fun getAll(): List<CharacterStorage>

    suspend fun add(characterStorage: CharacterStorage)

    suspend fun remove(characterStorage: CharacterStorage)

}