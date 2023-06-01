package com.example.genshinbook.presentaion.screen.main.elements.characters.vm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.genshinbook.domain.usecase.characters.*
import com.example.genshinbook.presentaion.model.character.Character
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*
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

    @OptIn(ExperimentalCoroutinesApi::class)
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
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
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
        Dispatchers.setMain(Dispatchers.Unconfined)
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

    //getAllCharacters
    @Test
    fun `get characters with normal internet`() = runBlocking{
        //get ready
        val character = mock<Character>()
        val list = listOf(
            character,
            character,
            character,
            character,
        )
        Mockito.`when`(getAllInfoCharactersUseCase.execute()).thenReturn(list)
        //call
        viewModel.getAllCharacters()
        //assert
        val expanded = CharactersTabViewState(
            characters = list.toMutableList(),
            isLoading = false,
            isError = false,
            isOffline = false
        )
        delay(3000)
        var actual = viewModel.state.value
        Assert.assertEquals(expanded,actual)
    }

    @Test
    fun `get characters without normal internet`() = runBlocking{
        //get ready
        val character = mock<Character>()
        val list = listOf(
            character.apply { isDownload = true },
            character.apply { isDownload = true },
            character.apply { isDownload = true },
            character.apply { isDownload = true },
        ).toMutableList()

        Mockito.`when`(getAllInfoCharactersUseCase.execute()).thenThrow(RuntimeException("Custom Exception"))
        Mockito.`when`(getAllCharactersFromStorage.execute()).thenReturn(list)
        //call
        viewModel.getAllCharacters()
        //assert
        val expanded = CharactersTabViewState(
            characters = list,
            isLoading = false,
            isError = true,
            isOffline = true
        )
        delay(3000)
        val actual = viewModel.state.value
        Assert.assertEquals(expanded,actual)
    }



}