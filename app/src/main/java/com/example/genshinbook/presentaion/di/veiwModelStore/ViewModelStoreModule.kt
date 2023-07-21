package com.example.genshinbook.presentaion.di.veiwModelStore

import com.example.genshinbook.domain.usecase.characters.*
import com.example.genshinbook.presentaion.screen.main.elements.characters.vm.CharactersTabViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelStoreModule {

    @Provides
    fun provideCharacterTab(
        getAllCharactersFromStorageUseCase: com.example.domain_characters.domain.usecase.characters.GetAllCharactersFromStorageUseCase,
        getAllInfoCharactersUseCase: com.example.domain_characters.domain.usecase.characters.GetAllInfoCharactersUseCase,
        getAllNameCharactersUseCase: com.example.domain_characters.domain.usecase.characters.GetAllNameCharactersUseCase,
        getCurrentInfoCharacterUseCase: com.example.domain_characters.domain.usecase.characters.GetCurrentInfoCharacterUseCase,
        isCharacterInTheDatabaseUseCase: com.example.domain_characters.domain.usecase.characters.IsCharacterInTheDatabaseUseCase,
        addCharacterToStorageUseCase: com.example.domain_characters.domain.usecase.characters.AddCharacterToStorageUseCase,
        removeCharacterFromStorageUseCase: com.example.domain_characters.domain.usecase.characters.RemoveCharacterFromStorageUseCase
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