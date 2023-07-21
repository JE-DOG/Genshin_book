package com.example.genshinbook.presentaion.di.veiwModelStore

import com.example.domain_characters.usecase.AddCharacterToStorageUseCase
import com.example.domain_characters.usecase.GetAllCharactersFromStorageUseCase
import com.example.domain_characters.usecase.GetAllInfoCharactersUseCase
import com.example.domain_characters.usecase.GetAllNameCharactersUseCase
import com.example.domain_characters.usecase.GetCurrentInfoCharacterUseCase
import com.example.domain_characters.usecase.IsCharacterInTheDatabaseUseCase
import com.example.domain_characters.usecase.RemoveCharacterFromStorageUseCase
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