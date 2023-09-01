package com.example.genshinbook.di.module

import android.content.Context
import android.content.SharedPreferences
import com.example.core.keys.SharedPreferencesKeys
import com.example.data.characters.storage.model.CharacterStorage
import com.example.data.characters.storage.model.ConstellationStorage
import com.example.data.characters.storage.model.PassiveTalentStorage
import com.example.data.characters.storage.model.SkillTalentStorage
import com.example.data.characters.storage.model.UpgradesStorage
import com.example.genshinbook.App
import com.example.genshinbook.di.AppScope
import dagger.Module
import dagger.Provides
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.realtime.Realtime
import io.ktor.client.HttpClient
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DataModule {

    @Provides
    @AppScope
    fun provideRealm(
        realmConfig: RealmConfiguration
    ): Realm {
        val realm = Realm.open(realmConfig)
        return realm
    }

    @AppScope
    @Provides
    fun provideRealmConfig(): RealmConfiguration {
        val realmConfig = RealmConfiguration.Builder(
            setOf(
                CharacterStorage::class,
                ConstellationStorage::class,
                PassiveTalentStorage::class,
                SkillTalentStorage::class,
                UpgradesStorage::class
            )
        )
            .deleteRealmIfMigrationNeeded()
            .compactOnLaunch()
            .build()
        return realmConfig
    }

    @AppScope
    @Provides
    fun provideSharedPreferences(
        context: Context
    ): SharedPreferences {
        return context.getSharedPreferences(App.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory{
        val gson = GsonConverterFactory.create()
        return gson
    }

    @AppScope
    @Provides
    fun provideHttpInterceptor(): Interceptor{
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
        return interceptor
    }

    @AppScope
    @Provides
    fun provideHttpClient(
        interceptor: Interceptor
    ): OkHttpClient {

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return okHttpClient
    }

    @AppScope
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit
    }

    @Provides
    @AppScope
    fun provideSupabaseClient(): SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = "https://ykjjabiybawaxcaxcuua.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InlramphYml5YmF3YXhjYXhjdXVhIiwicm9sZSI6ImFub24iLCJpYXQiOjE2ODg2NTIwMDMsImV4cCI6MjAwNDIyODAwM30.e7QiZZHHaVyNEQQoFj3hNd11A29MqIF3jr2FTU8Mvmc"
        ){
            install(Postgrest)
            install(GoTrue)
            install(Realtime)
        }
    }

    @Provides
    fun provideUserId(
        sharedPreferences: SharedPreferences
    ): String {
        val result = sharedPreferences.getString(SharedPreferencesKeys.USER_ID_KEY,"")
        return result!!
    }

    companion object {

        const val BASE_URL = "https://api.genshin.dev/"

    }
}