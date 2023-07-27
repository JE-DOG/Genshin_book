package com.example.data.characters.storage.repository

import com.example.data.characters.storage.model.CharacterStorage
import io.realm.kotlin.Realm
import javax.inject.Inject

class CharacterStorageRepositoryImpl @Inject constructor(
    private val dataBase: Realm
): CharacterStorageRepository {

    override suspend fun getAll(): List<CharacterStorage> {
        val result = dataBase.query(CharacterStorage::class).find()
        return result
    }

    override suspend fun add(characterStorage: CharacterStorage) {
        dataBase.write {
            this.copyToRealm(characterStorage)
        }
    }

    override suspend fun remove(characterStorage: CharacterStorage) {
        val result = dataBase
            .query(CharacterStorage::class,"name CONTAINS[c] $0",characterStorage.name)
            .query("vision_key CONTAINS[c] $0",characterStorage.vision_key)
            .first()
            .find()

        dataBase.write {
            result?.let { result ->
                this.findLatest(result)!!.also { delete(it) }
            }
        }
    }

    override suspend fun isInTheDataBase(characterStorage: CharacterStorage): Boolean {
        val result = dataBase
            .query(CharacterStorage::class,"name CONTAINS[c] $0",characterStorage.name)
            .query("vision_key CONTAINS[c] $0",characterStorage.vision_key)
            .find()

        return result.isNotEmpty()
    }
}