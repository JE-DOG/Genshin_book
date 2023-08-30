package com.example.feature.main.weapons.data.storage.service.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.feature.main.weapons.data.model.service.storage.model.WeaponEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface MainWeaponDao {

    @Query("SELECT * " +
            "FROM ${WeaponEntity.TABLE_NAME}")
    fun getAllWeapons(): Single<List<WeaponEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveWeapon(weaponEntity: WeaponEntity): Completable

    @Delete
    fun deleteWeapon(weaponEntity: WeaponEntity): Completable

}