package com.example.feature.main.weapons.di.deps

import android.content.Context
import retrofit2.Retrofit

interface FeatureMainWeaponsComponentDeps {

    val retrofit: Retrofit

    val context: Context

}