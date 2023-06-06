package com.example.genshinbook.data.network

import com.example.genshinbook.data.network.api.CharactersApi
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.genshin.dev/"

object Network {

    //todo Remove this into DI

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val charactersApi: CharactersApi = retrofit.create(CharactersApi::class.java)

}