package com.example.genshinbook.presentaion.screen.main.elements.characters.vm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.genshinbook.domain.usecase.characters.*
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class CharactersTabViewModelTest{

    @get: Rule
    val rule = InstantTaskExecutorRule()

    val getAllInfoCharactersUseCase = mock<GetAllInfoCharactersUseCase>()
    val getAllNameCharactersUseCase = mock<GetAllNameCharactersUseCase>()
    val getCurrentInfoCharacterUseCase = mock<GetCurrentInfoCharacterUseCase>()
    val isCharacterInTheDatabaseUseCase = mock<IsCharacterInTheDatabaseUseCase>()
    val addCharacterToStorageUseCase = mock<AddCharacterToStorageUseCase>()
    val removeCharacterFromStorageUseCase = mock<RemoveCharacterFromStorageUseCase>()
    val getAllCharactersFromStorage = mock<GetAllCharactersFromStorageUseCase>()

    lateinit var viewModel: CharactersTabViewModel

    @After
    fun afterEach(){
        Mockito.reset(
            getAllCharactersFromStorage,
            removeCharacterFromStorageUseCase,
            addCharacterToStorageUseCase,
            isCharacterInTheDatabaseUseCase,
            getCurrentInfoCharacterUseCase,
            getAllNameCharactersUseCase,
            getAllInfoCharactersUseCase
        )
    }

    @Before
    fun beforeEach(){
        viewModel = CharactersTabViewModel(
            getAllInfoCharactersUseCase,
            getAllNameCharactersUseCase,
            getCurrentInfoCharacterUseCase,
            isCharacterInTheDatabaseUseCase,
            addCharacterToStorageUseCase,
            removeCharacterFromStorageUseCase,
            getAllCharactersFromStorage
        )
    }

    @Test
    fun changeState(){
        val expanded = CharactersTabViewState(
            isLoading = true,
            isError = true,
            isOffline = true
        )

        viewModel.changeState(
            expanded
        )

        val actual = viewModel.state.value
        Assert.assertEquals(expanded,actual)
    }

}