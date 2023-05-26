package com.example.genshinbook.presentaion.screen.main.elements.characters.vm

import androidx.lifecycle.MutableLiveData
import com.example.genshinbook.core.base.BaseViewModel
import com.example.genshinbook.domain.usecase.characters.GetAllInfoCharactersUseCase
import com.example.genshinbook.domain.usecase.characters.GetAllNameCharactersUseCase
import com.example.genshinbook.domain.usecase.characters.GetCurrentInfoCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersTabViewModel @Inject constructor(
    private val getAllInfoCharactersUseCase: GetAllInfoCharactersUseCase,
    private val getAllNameCharactersUseCase: GetAllNameCharactersUseCase,
    private val getCurrentInfoCharacterUseCase: GetCurrentInfoCharacterUseCase
): BaseViewModel() {

    private val _state = MutableLiveData(
        CharactersTabViewState()
    )
    val state = _state

    fun getAllInfoCharactersUseCase(){

        launchIoCoroutine(
            error = {
                _state.value = state.value!!.copy(
                    isError = true
                )
            }
        ){
            _state.value = state.value!!.copy(
                isError = false,
                isLoading = true
            )

            val result = getAllInfoCharactersUseCase.execute()

            _state.value = state.value!!.copy(
                characters = result,
                isLoading = false
            )
        }

    }

    fun changeErrorState(){
        _state.value = state.value!!.copy(
            isError = false
        )
    }

}