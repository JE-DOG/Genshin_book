package com.example.genshinbook.utils.ext

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.domain_characters.di.CharactersDomainComponent
import com.example.genshinbook.App
import com.example.genshinbook.di.AppComponent
import com.example.genshinbook.presentaion.di.veiwModelStore.ViewModelStoreComponent

val Context.appComponent: AppComponent
    get() = when(this){

    is App -> this.appComponent

    else -> this.applicationContext.appComponent
}


val Context.characterDomainComponent: CharactersDomainComponent
    get() = when(this){

         is App -> this.charactersDomainComponent

         else -> this.applicationContext.characterDomainComponent

}