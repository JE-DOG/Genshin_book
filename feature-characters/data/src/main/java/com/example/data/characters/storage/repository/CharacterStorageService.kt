package com.example.data.characters.storage.repository

import com.example.data.characters.storage.model.CharacterStorage

interface CharacterStorageService {

    suspend fun getAll(): List<CharacterStorage>

    suspend fun add(characterStorage: CharacterStorage)

    suspend fun remove(characterStorage: CharacterStorage)

    suspend fun isInTheDataBase(characterStorage: CharacterStorage):Boolean

}