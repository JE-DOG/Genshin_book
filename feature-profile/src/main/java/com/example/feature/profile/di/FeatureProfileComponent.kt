package com.example.feature.profile.di

import com.example.feature.profile.ProfileFragment
import com.example.feature.profile.di.deps.FeatureProfileDeps
import com.example.feature.profile.di.module.FeatureProfileModule
import dagger.Component

@FeatureProfileComponentScope
@Component(
    modules = [
        FeatureProfileModule::class
    ],
    dependencies = [
        FeatureProfileDeps::class
    ]
)
interface FeatureProfileComponent {
    fun inject(profileFragment: ProfileFragment)

    @Component.Factory
    interface Factory {

        fun create(
            deps: FeatureProfileDeps
        ): FeatureProfileComponent

    }

}