package com.example.genshinbook.di

import com.example.genshinbook.presentaion.di.veiwModelStore.ViewModelStoreComponent
import dagger.Component
import io.realm.kotlin.Realm

@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    //subcomponent
    val viewModelStoreComponent:ViewModelStoreComponent.Builder

    val realm: Realm

}