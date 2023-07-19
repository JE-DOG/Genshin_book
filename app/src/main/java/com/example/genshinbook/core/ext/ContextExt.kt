package com.example.genshinbook.core.ext

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.genshinbook.App
import com.example.genshinbook.di.AppComponent
import com.example.genshinbook.presentaion.di.veiwModelStore.ViewModelStoreComponent

val Context.appComponent: AppComponent
    get() = when(this){

    is App -> this.appComponent

    else -> this.applicationContext.appComponent
}


val Context.viewModelStore: ViewModelStoreComponent
    get() = when(this){

         is App -> this.viewModelStoreComponent

         else -> this.applicationContext.viewModelStore

}

@Composable
fun ViewModelStore(): ViewModelStoreComponent{
    val context = LocalContext.current

    return context.viewModelStore
}
