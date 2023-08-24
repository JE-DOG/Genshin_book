package com.example.feature.characters.di.deps

import io.realm.kotlin.Realm
import retrofit2.Retrofit

interface FeatureCharactersDeps {

    val retrofit: Retrofit

    val realm: Realm

}