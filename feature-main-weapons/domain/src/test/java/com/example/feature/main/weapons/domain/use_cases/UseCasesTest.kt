package com.example.feature.main.weapons.domain.use_cases

import com.example.feature.main.weapons.domain.*
import com.example.feature.main.weapons.domain.model.WeaponDomain
import io.reactivex.Single
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock


class UseCasesTest {

    val mainWeaponResult = mock<MainWeaponRepository>()

    @Test
    fun getAllFromStorage(){
        //get ready
        val getAllFromStorageUseCase = GetAllWeaponFromStorageUseCase(mainWeaponResult)
        val weaponsList = listOf(
            mock<WeaponDomain>(),
            mock<WeaponDomain>(),
            mock<WeaponDomain>(),
            mock<WeaponDomain>(),
            mock<WeaponDomain>()
        )

        Mockito.`when`(mainWeaponResult.getAllFromStorage()).thenReturn(Single.just(weaponsList))
        //call
        val actual = getAllFromStorageUseCase.execute()
            .blockingGet()
        //compare
        val expected = weaponsList
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun getAllFromNetwork(){
        //get ready
        val getAllFromNetworkUseCase = GetAllWeaponFromNetworkUseCase(mainWeaponResult)
        val weaponsList = listOf(
            mock<WeaponDomain>(),
            mock<WeaponDomain>(),
            mock<WeaponDomain>(),
            mock<WeaponDomain>(),
            mock<WeaponDomain>()
        )

        Mockito.`when`(mainWeaponResult.getAllFromNetwork()).thenReturn(Single.just(weaponsList))
        //call
        val actual = getAllFromNetworkUseCase.execute()
            .blockingGet()
        //compare
        val expected = weaponsList
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun deleteFromStorage_Success(){
        //get ready
        val deleteFromStorageUseCase = DeleteWeaponFromStorageUseCase(mainWeaponResult)
        val weapon = mock<WeaponDomain>()

        Mockito.`when`(mainWeaponResult.deleteFromStorage(weapon)).thenReturn(Single.just(true))
        //call
        val actual = deleteFromStorageUseCase.execute(weapon)
            .blockingGet()
        //compare
        val expected = true
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun deleteFromStorage_Failure(){
        //get ready
        val deleteFromStorageUseCase = DeleteWeaponFromStorageUseCase(mainWeaponResult)
        val weapon = mock<WeaponDomain>()

        Mockito.`when`(mainWeaponResult.deleteFromStorage(weapon)).thenReturn(Single.just(false))
        //call
        val actual = deleteFromStorageUseCase.execute(weapon)
            .blockingGet()

        //compare
        val expected = false
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun saveFromStorage_Failure(){
        //get ready
        val deleteFromStorageUseCase = SaveWeaponToStorageUseCase(mainWeaponResult)
        val weapon = mock<WeaponDomain>()

        Mockito.`when`(mainWeaponResult.saveToStorage(weapon)).thenReturn(Single.just(false))
        //call
        val actual = deleteFromStorageUseCase.execute(weapon)
            .blockingGet()
        //compare
        val expected = false
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun saveFromStorage_Success(){
        //get ready
        val deleteFromStorageUseCase = SaveWeaponToStorageUseCase(mainWeaponResult)
        val weapon = mock<WeaponDomain>()

        Mockito.`when`(mainWeaponResult.saveToStorage(weapon)).thenReturn(Single.just(true))
        //call
        val actual = deleteFromStorageUseCase.execute(weapon)
            .blockingGet()
        //compare
        val expected = true
        Assert.assertEquals(expected, actual)
    }

}