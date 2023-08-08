package com.example.feature.add.chat.di.component

import com.example.core.app.navigation.ScreenProvider
import com.github.terrakok.cicerone.Router
import io.github.jan.supabase.SupabaseClient

interface FeatureAddChatDeps {

    val supabaseClient: SupabaseClient

    val userId: String

    val router: Router

    val screenProvider: ScreenProvider

}