package com.example.genshinbook.presentaion.screen.main.elements.characters.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.genshinbook.core.base.vm.BaseViewModel
import com.example.genshinbook.domain.usecase.characters.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import javax.inject.Inject
import com.example.genshinbook.presentaion.model.character.Character

@HiltViewModel
class CharactersTabViewModel @Inject constructor(
    private val getAllInfoCharactersUseCase: GetAllInfoCharactersUseCase,
    private val getAllNameCharactersUseCase: GetAllNameCharactersUseCase,
    private val getCurrentInfoCharacterUseCase: GetCurrentInfoCharacterUseCase,
    private val isCharacterInTheDatabaseUseCase: IsCharacterInTheDatabaseUseCase,
    private val addCharacterToStorageUseCase: AddCharacterToStorageUseCase,
    private val removeCharacterFromStorageUseCase: RemoveCharacterFromStorageUseCase,
    private val getAllCharactersFromStorage: GetAllCharactersFromStorageUseCase
): BaseViewModel() {

    private val _state = MutableLiveData(
        CharactersTabViewState()
    )
    val state = _state

    fun getAllInfoCharactersUseCase(){

        if (state.value!!.characters.isEmpty() || state.value!!.isOffline){
            launchIoCoroutine(
                error = {
                    _state.value = state.value!!.copy(
                        isError = true,
                        isLoading = false,
                        isOffline = true
                    )
                    getAllCharacterFromStorage()
                }
            ){
                _state.postValue(
                    state.value!!.copy(
                        isError = false,
                        isLoading = true,
                    )
                )
                val result = viewModelScope.async {
                    val list = getAllInfoCharactersUseCase.execute()
                    checkingCharacterListForDownloadedElements(list.toMutableList())
                }



                _state.postValue(
                    state.value!!.copy(
                        characters = result.await(), //todo maybe this error because we give mutable list ,but in the state list
                        isLoading = false,
                        isError = false,
                        isOffline = false
                    )
                )
            }
        }

    }

    fun getAllCharacterFromStorage() {

        launchIoCoroutine {


            launchIoCoroutine(
                error = {
                    _state.value = state.value!!.copy(
                        isError = true,
                        isLoading = false,
                    )

                }
            ) {
                _state.postValue(
                    state.value!!.copy(
                        isLoading = true,
                    )
                )

                val result = getAllCharactersFromStorage.execute()

                _state.postValue(
                    state.value!!.copy(
                        characters = result, //todo maybe this error because we give mutable list ,but in the state list
                        isLoading = false
                    )
                )
            }
        }


    }



    private fun removeCharacterFromStorage(character: Character){
        launchIoCoroutine {
            removeCharacterFromStorageUseCase.execute(character = character)
        }
    }

    fun characterDownload(character: Character,isDownload: Boolean){
        val list = state.value!!.characters
        if (isDownload){
            removeCharacterFromStorage(character)
        }else{
            addCharacterToStorage(character)
        }

        val index = list.lastIndexOf(character)
        if (index != -1){
            list[index] = character.apply {
                Log.d("checkingCharacterForDownloaded", "before:\n${this.name} -> Downloaded(${this.isDownload})")
                this.isDownload = !this.isDownload
                Log.d("checkingCharacterForDownloaded", "after:\n${this.name} -> Downloaded(${this.isDownload})")
            }
        }
    }

    private fun addCharacterToStorage(character: Character){

        launchIoCoroutine {
            addCharacterToStorageUseCase.execute(character = character)
        }

    }

    private suspend fun checkingCharacterListForDownloadedElements(
        list: MutableList<Character>
    ): MutableList<Character>{

        for (it in list) {

            launchDefaultCoroutine {

                val result = isCharacterInTheDatabaseUseCase.execute(it)

                Log.d("checkingCharacterListForDownloadedElements", "${it.name} -> Downloaded($result)")

                if (result){
                    val index = list.lastIndexOf(it)
                    if (index != -1){
                        list[index] = it.apply { it.isDownload = true }
                    }
                }else{
                    val index = list.lastIndexOf(it)
                    if (index != -1){
                        list[index] = it.apply { it.isDownload = false }
                    }
                }

            }

        }

        return list
    }

    private suspend fun checkingCharacterForDownloaded(
        character: Character
    ){
        val result = isCharacterInTheDatabaseUseCase.execute(character)
        val list = state.value!!.characters
        val index = list.lastIndexOf(character)


        if (result){
            if (index != -1){
                list[index] = character.apply {
                    Log.d("checkingCharacterForDownloaded", "before:\n${this.name} -> Downloaded(${this.isDownload})")
                    character.isDownload = true
                    Log.d("checkingCharacterForDownloaded", "after:\n${this.name} -> Downloaded(${this.isDownload})")
                }
            }
        }else{
            if (index != -1){
                list[index] = character.apply {
                    Log.d("checkingCharacterForDownloaded", "before:\n${this.name} -> Downloaded(${this.isDownload})")
                    character.isDownload = false
                    Log.d("checkingCharacterForDownloaded", "after:\n${this.name} -> Downloaded(${this.isDownload})")
                }
            }
        }
    }

    fun changeState(state: CharactersTabViewState){
        _state.value = state
    }

}