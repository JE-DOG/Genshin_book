package com.example.data_characters.network.api

import com.example.data_characters.network.model.CharacterNetwork
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

private const val GET_CURRENT = "characters/{character}"
private const val GET_ALL_NAME = "characters"
private const val GET_ALL = "characters/all"

interface CharactersApi {

    @GET(GET_ALL_NAME)
    suspend fun getAllName():Response<List<String>>

    @GET(GET_CURRENT)
    suspend fun getCurrentInfo(@Path("character") character: String): Response<CharacterNetwork>

    @GET(GET_ALL)
    suspend fun getAllInfo(): Response<List<CharacterNetwork>>

}