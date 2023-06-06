package com.example.genshinbook.presentaion.di.veiwModelStore

import com.example.genshinbook.presentaion.screen.main.elements.characters.vm.CharactersTabViewModel
import dagger.Subcomponent

@Subcomponent(
    modules = [
        ViewModelStoreModule::class
    ]
)
interface ViewModelStoreComponent {

    @Subcomponent.Builder
    interface Builder{
        fun build(): ViewModelStoreComponent
    }

    val characterTab: CharactersTabViewModel

}