package com.example.data_characters.storage.repository

import com.example.data_characters.storage.model.CharacterStorage

interface CharacterStorageRepository {

    suspend fun getAll(): List<CharacterStorage>

    suspend fun add(characterStorage: CharacterStorage)

    suspend fun remove(characterStorage: CharacterStorage)

    suspend fun isInTheDataBase(characterStorage: CharacterStorage):Boolean

}