package com.example.feature.main.weapons.di.component

import com.example.feature.main.weapons.di.deps.FeatureMainWeaponsComponentDeps
import dagger.Component

@FeatureMainWeaponsScope
@Component(
    modules = [

    ],
    dependencies = [
        FeatureMainWeaponsComponentDeps::class
    ]
)
interface FeatureMainWeaponsComponent {

    @Component.Factory
    interface Factory {

        fun create(
            deps: FeatureMainWeaponsComponentDeps
        ): FeatureMainWeaponsComponent

    }

}