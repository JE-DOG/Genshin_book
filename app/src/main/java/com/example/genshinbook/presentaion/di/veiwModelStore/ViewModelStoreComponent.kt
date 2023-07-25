package com.example.genshinbook.presentaion.di.veiwModelStore

import com.example.genshinbook.di.AppScope
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