package com.example.genshinbook.utils.ext

import android.content.Context
import com.example.genshinbook.App
import com.example.genshinbook.di.AppComponent

val Context.appComponent: AppComponent
    get() = when(this){

    is App -> this.appComponent

    else -> this.applicationContext.appComponent

}