package com.example.feature.main.weapons.vm

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.app.ext.subscribe
import com.example.core.app.ext.update
import com.example.core.app.ext.updatePostValue
import com.example.core.app.ui.xml.base.vm.BaseViewModel
import com.example.feature.main.weapons.domain.use_cases.DeleteWeaponFromStorageUseCase
import com.example.feature.main.weapons.domain.use_cases.GetAllWeaponFromNetworkUseCase
import com.example.feature.main.weapons.domain.use_cases.GetAllWeaponFromStorageUseCase
import com.example.feature.main.weapons.domain.use_cases.SaveWeaponToStorageUseCase
import com.example.feature.main.weapons.model.WeaponPresentation
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import io.realm.kotlin.internal.platform.runBlocking
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.zip
import okhttp3.internal.concurrent.Task
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
                .doOnSuccess { weaponsStorage ->
                    Log.d("WeaponsTabViewModelErrorTag",Thread.currentThread().name)
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
                            Log.d("WeaponsTabViewModelErrorTag",Thread.currentThread().name)
                        }
                        .doOnError {
                            Log.d("WeaponsTabViewModelErrorTag","doOnError thread -> " + Thread.currentThread().name)

                            _state.updatePostValue { state ->
                                state.copy(
                                    isOffline = true,
                                    isLoading = false,
                                    isError = true,
                                    weapons = weaponsStorage.toMutableList()
                                )
                            }
                        }
                        .doOnSuccess { weapons ->
                            _state.updatePostValue { state ->
                                state.copy(
                                    isLoading = false,
                                    isOffline = false,
                                    weapons = weapons.toMutableList()
                                )
                            }

                        }
                        .subscribe(
                            onError = {}
                        )
                }
                .subscribe(
                    onError = {}
                )
        )

    }

    fun saveWeapon(weapon: WeaponPresentation): Completable{
        val result = saveWeaponToStorageUseCase.execute(
            weapon
                .toDomain()
        )
            .doOnComplete {
                weapon.isDownloaded = true
            }
        return result
    }

    fun deleteWeapon(weapon: WeaponPresentation): Completable {
        val result =  deleteWeaponsFromStorageUseCase.execute(
            weapon
                .toDomain()
        )
            .doOnComplete {
                weapon.isDownloaded = false
            }
        return result
    }

    fun changeState(
        state: WeaponsTabViewState
    ){
        _state.update {
            state
        }
    }

}