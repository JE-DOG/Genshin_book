package com.example.genshinbook.data.network.api

import com.example.genshinbook.data.network.model.characters.CharacterNetwork
import retrofit2.http.GET
import retrofit2.http.Path

private const val GET_CURRENT = "characters/{character}"
private const val GET_ALL = "characters"

interface CharactersApi {

    @GET(GET_ALL)
    suspend fun getAll():List<String>

    @GET(GET_CURRENT)
    suspend fun getCurrent(@Path("character") character: String): CharacterNetwork

}