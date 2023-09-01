package com.example.feature.main.weapons.vm

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.app.ext.update
import com.example.core.app.ext.updatePostValue
import com.example.core.app.ui.xml.base.vm.BaseViewModel
import com.example.feature.main.weapons.domain.use_cases.DeleteWeaponFromStorageUseCase
import com.example.feature.main.weapons.domain.use_cases.GetAllWeaponFromNetworkUseCase
import com.example.feature.main.weapons.domain.use_cases.GetAllWeaponFromStorageUseCase
import com.example.feature.main.weapons.domain.use_cases.SaveWeaponToStorageUseCase
import com.example.feature.main.weapons.model.WeaponPresentation
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class WeaponsTabViewModel(
    private val getAllWeaponFromNetworkUseCase: GetAllWeaponFromNetworkUseCase,
    private val getAllWeaponFromStorageUseCase: GetAllWeaponFromStorageUseCase,
    private val saveWeaponToStorageUseCase: SaveWeaponToStorageUseCase,
    private val deleteWeaponsFromStorageUseCase: DeleteWeaponFromStorageUseCase
): BaseViewModel() {

    class Factory @Inject constructor(
        private val getAllWeaponFromNetworkUseCase: GetAllWeaponFromNetworkUseCase,
        private val getAllWeaponFromStorageUseCase: GetAllWeaponFromStorageUseCase,
        private val saveWeaponToStorageUseCase: SaveWeaponToStorageUseCase,
        private val deleteWeaponsFromStorageUseCase: DeleteWeaponFromStorageUseCase
    ): ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return WeaponsTabViewModel(
                getAllWeaponFromNetworkUseCase = getAllWeaponFromNetworkUseCase ,
                getAllWeaponFromStorageUseCase = getAllWeaponFromStorageUseCase,
                saveWeaponToStorageUseCase = saveWeaponToStorageUseCase,
                deleteWeaponsFromStorageUseCase = deleteWeaponsFromStorageUseCase
            ) as T
        }

    }

    private val _state = MutableLiveData(WeaponsTabViewState())
    val state = _state

    @SuppressLint("CheckResult")
    fun getAllWeapons(){

        subscribers.add(
            getAllWeaponFromStorageUseCase.execute()
                .map {  listWeapons ->
                    listWeapons.map { weaponDomain ->
                        WeaponPresentation.fromDomain(weaponDomain)
                    }
                }
                .doOnError {
                    _state.updatePostValue {
                        it.copy(
                            isOffline = true,
                            isLoading = false,
                            isError = true
                        )
                    }
                }
                .doOnSuccess { weaponsStorage ->
                    getAllWeaponFromNetworkUseCase.execute()
                        .map {  listWeapons ->
                            listWeapons.map { weaponDomain ->
                                val weaponPresentation = WeaponPresentation
                                    .fromDomain(weaponDomain)

                                for (weaponStorage in weaponsStorage){
                                    if (weaponPresentation.name == weaponStorage.name){
                                        weaponPresentation.isDownloaded = true
                                        break
                                    }
                                }

                                return@map weaponPresentation
                            }
                        }
                        .doOnSubscribe {
                            _state.updatePostValue {
                                it.copy(
                                    isLoading = true,
                                    isError = false
                                )
                            }
                        }
                        .doOnError {
                            _state.updatePostValue { state ->
                                state.copy(
                                    isOffline = true,
                                    isLoading = false,
                                    isError = true
                                )
                            }
                        }
                        .doOnSuccess { weapons ->
                            _state.updatePostValue { state ->
                                Log.d("WeaponsTabViewModelTag","WeaponsNetwork: ${weapons.size}")
                                Log.d("WeaponsTabViewModelTag","WeaponsRuntime: ${state.weapons.size}")

                                state.copy(
                                    isLoading = false,
                                    weapons = weapons.toMutableList()
                                )
                            }

                        }
                        .subscribe()
                }
                .subscribe()
        )

    }

    fun saveWeapon(weapon: WeaponPresentation){

        subscribers.add(
            saveWeaponToStorageUseCase.execute(
                weapon
                    .toDomain()
            )
                .doOnComplete {
                    weapon.apply {
                        isDownloaded = true
                    }
                }
                .subscribe()
        )

    }

    fun deleteWeapon(weapon: WeaponPresentation){

        subscribers.add(
            deleteWeaponsFromStorageUseCase.execute(
                weapon
                    .toDomain()
            )
                .doOnComplete {
                    weapon.apply {
                        isDownloaded = false
                    }
                }
                .subscribe()
        )

    }

    fun changeState(
        state: WeaponsTabViewState
    ){
        _state.update {
                state
        }
    }

}