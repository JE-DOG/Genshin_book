package com.example.demo.feature.chat.di

import com.example.feature.chats.list.di.component.FeatureChatsListDeps
import com.github.terrakok.cicerone.Router
import dagger.Component
import io.github.jan.supabase.SupabaseClient

@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent: FeatureChatsListDeps {

    override val userId: String

    override val router: Router

    override val supabaseClient: SupabaseClient

}