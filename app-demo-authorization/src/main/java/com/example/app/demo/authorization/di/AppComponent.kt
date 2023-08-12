package com.example.app.demo.authorization.di

import android.content.Context
import com.example.app.demo.authorization.DemoAuthorizationActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    fun inject(demoAuthorizationActivity: DemoAuthorizationActivity)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance
            context: Context
        ): AppComponent

    }
}