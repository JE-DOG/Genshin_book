package com.example.genshinbook.presentaion.di.veiwModelStore

import com.example.genshinbook.di.AppScope
import com.example.genshinbook.presentaion.screen.main.elements.characters.vm.CharactersTabViewModel
import dagger.Component

@AppScope
@Component(
    modules = [
        ViewModelStoreModule::class
    ],

)
interface ViewModelStoreComponent {

    @Component.Builder
    interface Builder{
        fun build(): ViewModelStoreComponent
    }

}