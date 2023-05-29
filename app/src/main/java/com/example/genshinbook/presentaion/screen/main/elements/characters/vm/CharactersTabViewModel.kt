package com.example.genshinbook.presentaion.screen.main.elements.characters.vm

import androidx.lifecycle.MutableLiveData
import com.example.genshinbook.core.base.vm.BaseViewModel
import com.example.genshinbook.domain.usecase.characters.GetAllInfoCharactersUseCase
import com.example.genshinbook.domain.usecase.characters.GetAllNameCharactersUseCase
import com.example.genshinbook.domain.usecase.characters.GetCurrentInfoCharacterUseCase
import com.example.genshinbook.domain.usecase.characters.IsCharacterInTheDatabaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersTabViewModel @Inject constructor(
    private val getAllInfoCharactersUseCase: GetAllInfoCharactersUseCase,
    private val getAllNameCharactersUseCase: GetAllNameCharactersUseCase,
    private val getCurrentInfoCharacterUseCase: GetCurrentInfoCharacterUseCase,
    private val isCharacterInTheDatabaseUseCase: IsCharacterInTheDatabaseUseCase
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
                    )

                }
            ){
                _state.postValue(
                    state.value!!.copy(
                        isError = false,
                        isLoading = true,
                    )
                )
                val result = getAllInfoCharactersUseCase.execute()

                _state.postValue(
                    state.value!!.copy(
                        characters = result,
                        isLoading = false,
                        isError = false,
                    )
                )
            }
        }

    }

    fun changeErrorState(){
        _state.value = state.value!!.copy(
            isError = false
        )
    }

}