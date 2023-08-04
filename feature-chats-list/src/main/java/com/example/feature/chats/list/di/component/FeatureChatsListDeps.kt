package com.example.feature.chats.list.di.component

import com.example.core.app.di.UserIdQualifier
import com.github.terrakok.cicerone.Router
import io.github.jan.supabase.SupabaseClient

interface FeatureChatsListDeps {

    val userId: String

    val router: Router

    val supabaseClient: SupabaseClient

}