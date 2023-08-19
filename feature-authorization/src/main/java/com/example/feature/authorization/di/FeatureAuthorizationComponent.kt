package com.example.feature.authorization.di

import com.example.feature.authorization.di.deps.FeatureAuthorizationDeps
import com.example.feature.authorization.di.module.FeatureAuthorizationModule
import com.example.feature.authorization.screen.sign_in.SignInFragment
import com.example.feature.authorization.screen.sign_up.SignUpFragment
import dagger.Component

@FeatureAuthorizationComponentScope
@Component(
    modules = [
        FeatureAuthorizationModule::class
    ],
    dependencies = [
        FeatureAuthorizationDeps::class
    ]
)
interface FeatureAuthorizationComponent {

    fun inject(sIgnInFragment: SignInFragment)
    fun inject(sIgnUpFragment: SignUpFragment)

    @Component.Factory
    interface Factory {
        fun create(
            deps: FeatureAuthorizationDeps
        ): FeatureAuthorizationComponent

    }

}