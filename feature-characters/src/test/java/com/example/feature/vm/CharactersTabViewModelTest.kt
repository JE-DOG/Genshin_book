package com.example.feature.vm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.characters.model.CharacterDomain
import com.example.domain.characters.usecase.*
import com.example.feature.characters.vm.CharactersTabViewModel
import com.example.feature.characters.vm.CharactersTabViewState
import com.example.feature.characters.model.Character
import dagger.Lazy
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
    val getAllNameCharactersUseCase = mock<Lazy<GetAllNameCharactersUseCase>>()
    val getCurrentInfoCharacterUseCase = mock<Lazy<GetCurrentInfoCharacterUseCase>>()
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
        val character = CharacterDomain()
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
            characters = list.map{
                Character.fromDomain(it)
            }.toMutableList(),
            isLoading = false,
            isError = false,
            isOffline = false
        )
        delay(3000)
        val actual = viewModel.state.value
        Assert.assertEquals(expanded,actual)
    }

    @Test
    fun `get characters without normal internet`() = runBlocking{
        //get ready
        val character = CharacterDomain()
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
            characters = list.map {
                Character.fromDomain(it)
            }.toMutableList(),
            isLoading = false,
            isError = true,
            isOffline = true
        )
        delay(3000)
        val actual = viewModel.state.value
        Assert.assertEquals(expanded,actual)
    }

    //characterDownload
    @Test
    fun `remove character from data base`() = runBlocking{
        //get ready
        val character = Character()
        val characterDownloaded = Character(isDownload = true)
        val list = mutableListOf(
            character,
            character,
            characterDownloaded,
        )
        viewModel.changeState(
            CharactersTabViewState(characters = list)
        )
        //call
        viewModel.characterDownload(characterDownloaded)
        //assert
        val expended = character
        delay(2000)
        val actual = viewModel.state.value!!.characters[2]
        Assert.assertEquals(expended,actual)
    }

    @Test
    fun `add character to data base`() = runBlocking {
        //get ready
        val character1 = Character(name = "Number 1")
        val character2 = Character(name = "Number 2")
        val list = mutableListOf(
            character1,
            character2
        )
        viewModel.changeState(
            CharactersTabViewState(characters = list)
        )
        //call
        viewModel.characterDownload(character1)
        //assert
        val expended = Character(name = "Number 1", isDownload = true)
        delay(2000)
        val actual = viewModel.state.value!!.characters[0]
        Assert.assertEquals(expended,actual)
    }


}