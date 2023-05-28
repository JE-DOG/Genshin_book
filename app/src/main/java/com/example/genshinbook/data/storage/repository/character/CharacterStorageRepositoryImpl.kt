package com.example.genshinbook.data.storage.repository.character

import com.example.genshinbook.data.storage.model.CharacterStorage
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
        dataBase.write {
            this.delete(characterStorage)
        }
    }
}