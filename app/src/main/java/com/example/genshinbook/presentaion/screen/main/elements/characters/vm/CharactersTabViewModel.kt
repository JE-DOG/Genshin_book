package com.example.genshinbook.presentaion.screen.main.elements.characters.vm

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
    private val getAllCharactersFromStorage: GetAllCharactersFromStorage
): BaseViewModel() {

    private val _state = MutableLiveData(
        CharactersTabViewState()
    )
    val state = _state

    fun getAllInfoCharactersUseCase(){

        if (state.value!!.characters.isEmpty()){
            launchIoCoroutine(
                error = {
                    _state.value = state.value!!.copy(
                        isError = true,
                        isLoading = false,
                        isOffline = true
                    )

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
                    checkingListForDownloadedElements(list.toMutableList())
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

    fun getAllCharacterFromStorage(){

        launchIoCoroutine {

            if (state.value!!.characters.isEmpty()){
                launchIoCoroutine(
                    error = {
                        _state.value = state.value!!.copy(
                            isError = true,
                            isLoading = false,
                        )

                    }
                ){
                    _state.postValue(
                        state.value!!.copy(
                            isError = false,
                            isLoading = true,
                        )
                    )

                    val result = getAllCharactersFromStorage.execute()

                    _state.postValue(
                        state.value!!.copy(
                            characters = result, //todo maybe this error because we give mutable list ,but in the state list
                            isLoading = false,
                            isError = false
                        )
                    )
                }
            }

        }

    }

    fun removeCharacterFromStorage(character: Character){
        launchIoCoroutine {
            removeCharacterFromStorageUseCase.execute(character = character)
        }
    }

    fun addCharacterToStorage(character: Character){

        launchIoCoroutine {
            addCharacterToStorageUseCase.execute(character = character)
        }

    }

    private suspend fun checkingListForDownloadedElements(
        list: MutableList<Character>
    ):MutableList<Character>{

        for (it in list) {
            launchDefaultCoroutine {

                val result = isCharacterInTheDatabaseUseCase.execute(it)
                if (result){
                    val index = list.lastIndexOf(it)
                    if (index != -1){
                        list[index] = it.apply { it.isDownload = true }
                    }
                }

            }
        }

        return list
    }

    fun changeState(state: CharactersTabViewState){
        _state.value = state
    }

}