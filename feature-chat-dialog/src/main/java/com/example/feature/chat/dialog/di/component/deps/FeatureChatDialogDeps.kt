package com.example.feature.chat.dialog.di.component.deps

import com.github.terrakok.cicerone.Router
import io.github.jan.supabase.SupabaseClient

interface FeatureChatDialogDeps {

    val userId: String

    val router: Router

    val supabaseClient: SupabaseClient

}