package com.example.data.characters.storage.repository

import com.example.data.characters.storage.model.CharacterStorage
import io.realm.kotlin.Realm
import javax.inject.Inject

class CharacterStorageServiceImpl @Inject constructor(
    private val realm: Realm
): CharacterStorageService {

    override suspend fun getAll(): List<CharacterStorage> {
        val result = realm.query(CharacterStorage::class).find()
        return result
    }

    override suspend fun add(characterStorage: CharacterStorage) {
        realm.write {
            this.copyToRealm(characterStorage)
        }
    }

    override suspend fun remove(characterStorage: CharacterStorage) {
        val result = realm
            .query(CharacterStorage::class,"name CONTAINS[c] $0",characterStorage.name)
            .query("vision_key CONTAINS[c] $0",characterStorage.vision_key)
            .first()
            .find()

        realm.write {
            result?.let { result ->
                this.findLatest(result)!!.also { delete(it) }
            }
        }
    }

    override suspend fun isInTheDataBase(characterStorage: CharacterStorage): Boolean {
        val result = realm
            .query(CharacterStorage::class,"name CONTAINS[c] $0",characterStorage.name)
            .query("vision_key CONTAINS[c] $0",characterStorage.vision_key)
            .find()

        return result.isNotEmpty()
    }
}