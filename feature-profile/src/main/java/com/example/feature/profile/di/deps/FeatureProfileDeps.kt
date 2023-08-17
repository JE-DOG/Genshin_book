package com.example.feature.profile.di.deps

import com.example.core.app.navigation.ScreenProvider
import com.github.terrakok.cicerone.Router
import io.github.jan.supabase.SupabaseClient

interface FeatureProfileDeps {

    val supabaseClient: SupabaseClient

    val userId: String

    val router: Router

    val screenProcess: ScreenProvider

}