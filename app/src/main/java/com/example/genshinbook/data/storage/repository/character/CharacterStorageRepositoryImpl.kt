package com.example.genshinbook.data.storage.repository.character

import android.util.Log
import com.example.genshinbook.data.storage.model.CharacterStorage
import io.realm.kotlin.Realm
import io.realm.kotlin.delete
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

        result.forEach {
            Log.d("DataBaseTest",it.name)
        }


        return result.isNotEmpty()
    }
}