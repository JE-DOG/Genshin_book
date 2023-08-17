package com.example.app.demo.authorization.di

import android.content.Context
import android.content.SharedPreferences
import com.example.app.demo.authorization.DemoAuthorizationActivity
import com.example.core.app.navigation.ScreenProvider
import com.example.feature.authorization.di.deps.FeatureAuthorizationComponentDeps
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
interface AppComponent: FeatureAuthorizationComponentDeps {

    fun inject(demoAuthorizationActivity: DemoAuthorizationActivity)

    override val router: Router

    override val screenProvider: ScreenProvider

    override val supabaseClient: SupabaseClient

    override val sharedPreferences: SharedPreferences

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance
            context: Context
        ): AppComponent

    }
}