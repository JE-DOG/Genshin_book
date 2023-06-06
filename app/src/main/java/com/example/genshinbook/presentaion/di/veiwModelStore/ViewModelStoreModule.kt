package com.example.genshinbook.presentaion.di.veiwModelStore

import com.example.genshinbook.domain.usecase.characters.*
import com.example.genshinbook.presentaion.screen.main.elements.characters.vm.CharactersTabViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelStoreModule {

    @Provides
    fun provideCharacterTab(
        getAllCharactersFromStorageUseCase: GetAllCharactersFromStorageUseCase,
        getAllInfoCharactersUseCase: GetAllInfoCharactersUseCase,
        getAllNameCharactersUseCase: GetAllNameCharactersUseCase,
        getCurrentInfoCharacterUseCase: GetCurrentInfoCharacterUseCase,
        isCharacterInTheDatabaseUseCase: IsCharacterInTheDatabaseUseCase,
        addCharacterToStorageUseCase: AddCharacterToStorageUseCase,
        removeCharacterFromStorageUseCase: RemoveCharacterFromStorageUseCase
    ) = CharactersTabViewModel(
        getAllCharactersFromStorage = getAllCharactersFromStorageUseCase,
        getAllInfoCharactersUseCase = getAllInfoCharactersUseCase,
        getAllNameCharactersUseCase = getAllNameCharactersUseCase,
        getCurrentInfoCharacterUseCase = getCurrentInfoCharacterUseCase,
        isCharacterInTheDatabaseUseCase = isCharacterInTheDatabaseUseCase,
        addCharacterToStorageUseCase = addCharacterToStorageUseCase,
        removeCharacterFromStorageUseCase =removeCharacterFromStorageUseCase
    )



}