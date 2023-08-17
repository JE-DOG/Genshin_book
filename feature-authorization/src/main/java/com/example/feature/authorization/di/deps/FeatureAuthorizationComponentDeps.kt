package com.example.feature.authorization.di.deps

import android.content.SharedPreferences
import com.example.core.app.navigation.ScreenProvider
import com.github.terrakok.cicerone.Router
import io.github.jan.supabase.SupabaseClient

interface FeatureAuthorizationComponentDeps {

    val router: Router

    val screenProvider: ScreenProvider

    val supabaseClient: SupabaseClient

    val sharedPreferences: SharedPreferences

}