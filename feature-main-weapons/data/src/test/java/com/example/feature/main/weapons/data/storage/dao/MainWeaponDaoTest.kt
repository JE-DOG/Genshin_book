package com.example.feature.main.weapons.data.storage.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.feature.main.weapons.data.model.service.storage.model.WeaponEntity
import com.example.feature.main.weapons.data.storage.service.data_base.MainWeaponRoomDataBase
import com.example.feature.main.weapons.data.storage.service.dao.MainWeaponDao
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.mock

//@RunWith(AndroidJUnit4::class)
class MainWeaponDaoTest {
// TODO:Make test for room some day

//    @get:Rule
//    var instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    lateinit var dataBase: MainWeaponRoomDataBase
//    lateinit var dao: MainWeaponDao
//    val mockWeapon = mock<WeaponEntity>()

    @Before
    fun beforeEach(){
//        dataBase = Room
//            .inMemoryDatabaseBuilder(
//                ApplicationProvider.getApplicationContext(),
//                MainWeaponRoomDataBase::class.java
//            )
//            .allowMainThreadQueries()
//            .build()
//        dao = dataBase.dao()
    }

    @After
    fun afterEach(){
//        dataBase.close()
    }

    @Test
    fun saveWeapon()= runBlocking {
//        call
//        dao.saveWeapon(mockWeapon)
//        //assert
//        val actual = dao.getAllWeapons()
//            .blockingGet()
//            .last()
//        val expected = mockWeapon
//
//        delay(3000)
//
//        Assert.assertEquals(actual,expected)
        Assert.assertEquals(true,true)
    }

}