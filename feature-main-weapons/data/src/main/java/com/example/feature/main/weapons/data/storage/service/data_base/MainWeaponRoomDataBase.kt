package com.example.feature.main.weapons.data.storage.service.data_base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.feature.main.weapons.data.model.service.storage.model.WeaponEntity
import com.example.feature.main.weapons.data.storage.service.dao.MainWeaponDao

@Database(
    entities = [
        WeaponEntity::class
    ],
    version = 3
)
abstract class MainWeaponRoomDataBase: RoomDatabase() {

    abstract fun dao(): MainWeaponDao

}