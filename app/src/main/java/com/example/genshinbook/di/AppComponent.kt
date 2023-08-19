package com.example.genshinbook.di

import android.content.Context
import android.content.SharedPreferences
import com.example.core.app.navigation.ScreenProvider
import com.example.feature.add.chat.di.component.FeatureAddChatDeps
import com.example.feature.add.chat.di.component.FeatureAddChatDepsProvider
import com.example.feature.authorization.di.deps.FeatureAuthorizationDeps
import com.example.feature.chat.dialog.di.component.deps.FeatureChatDialogDeps
import com.example.feature.chats.list.di.component.FeatureChatsListDeps
import com.example.feature.profile.di.deps.FeatureProfileDeps
import com.example.genshinbook.MainActivity
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import io.github.jan.supabase.SupabaseClient

@AppScope
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent:
    FeatureAuthorizationDeps,
    FeatureAddChatDeps,
    FeatureChatDialogDeps,
    FeatureChatsListDeps,
    FeatureProfileDeps
{
    fun inject(mainActivity: MainActivity)

    override val router: Router

    override val screenProvider: ScreenProvider

    override val supabaseClient: SupabaseClient

    override val sharedPreferences: SharedPreferences

    override val userId: String

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance
            context: Context
        ): AppComponent

    }
}