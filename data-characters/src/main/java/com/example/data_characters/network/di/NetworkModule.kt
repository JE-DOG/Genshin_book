package com.example.data_characters.network.di

import com.example.data_characters.network.repository.di.CharacterNetworkModule
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.genshin.dev/"

@Module(
    includes = [
        CharacterNetworkModule::class
    ]
)
class NetworkModule{
    @Provides
    fun provideRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

}