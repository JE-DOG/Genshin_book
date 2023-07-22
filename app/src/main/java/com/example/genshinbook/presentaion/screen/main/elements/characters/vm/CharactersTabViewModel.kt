package com.example.genshinbook.presentaion.screen.main.elements.characters.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.core.base.vm.BaseViewModel
import com.example.domain_characters.model.CharacterDomain
import com.example.domain_characters.usecase.AddCharacterToStorageUseCase
import com.example.domain_characters.usecase.GetAllCharactersFromStorageUseCase
import com.example.domain_characters.usecase.GetAllInfoCharactersUseCase
import com.example.domain_characters.usecase.GetAllNameCharactersUseCase
import com.example.domain_characters.usecase.GetCurrentInfoCharacterUseCase
import com.example.domain_characters.usecase.IsCharacterInTheDatabaseUseCase
import com.example.domain_characters.usecase.RemoveCharacterFromStorageUseCase
import kotlinx.coroutines.async
import javax.inject.Inject
import com.example.genshinbook.presentaion.model.character.Character
import dagger.Lazy


class CharactersTabViewModel(
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

    fun getAllCharacters(){

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
                    checkingCharacterListForDownloadedElements(
                        list.map {
                            Character.fromDomain(it)
                        }.toMutableList()
                    )
                }



                _state.postValue(
                    state.value!!.copy(
                        characters = result.await(),
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

                val result = getAllCharactersFromStorage.execute().map {
                    Character.fromDomain(it)
                }.toMutableList()


                _state.postValue(
                    state.value!!.copy(
                        characters = result,
                        isLoading = false
                    )
                )
            }
        }


    }

    fun characterDownload(character: Character){
        if (character.isDownload){
            removeCharacterFromStorage(character)
        }else{
            addCharacterToStorage(character)
        }

        val list = state.value!!.characters
        val index = list.lastIndexOf(character)
        if (index != -1){
            list[index] = character.apply {
                this.isDownload = !this.isDownload
            }
        }
    }

    fun changeState(state: CharactersTabViewState){
        _state.value = state
    }
    private fun removeCharacterFromStorage(character: Character){
        launchIoCoroutine {
            removeCharacterFromStorageUseCase.execute(character = character.toDomain())
        }
    }

    private fun addCharacterToStorage(character: Character){

        launchIoCoroutine {
            addCharacterToStorageUseCase.execute(character = character.toDomain())
        }

    }

    private suspend fun checkingCharacterListForDownloadedElements(
        list: MutableList<Character>
    ): MutableList<Character>{

        for (it in list) {

            launchDefaultCoroutine {

                val result = isCharacterInTheDatabaseUseCase.execute(it.toDomain())

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
        val result = isCharacterInTheDatabaseUseCase.execute(character.toDomain())
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


}