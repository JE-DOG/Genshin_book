package com.example.feature.main.weapons.di.component

import com.example.feature.main.weapons.di.deps.FeatureMainWeaponsComponentDeps
import com.example.feature.main.weapons.di.module.DataModule
import com.example.feature.main.weapons.vm.WeaponsTabViewModel
import dagger.Component

@FeatureMainWeaponsScope
@Component(
    modules = [
        DataModule::class
    ],
    dependencies = [
        FeatureMainWeaponsComponentDeps::class
    ]
)
interface FeatureMainWeaponsComponent {

    val weaponsTabViewModelFactory: WeaponsTabViewModel.Factory

    @Component.Factory
    interface Factory {

        fun create(
            deps: FeatureMainWeaponsComponentDeps
        ): FeatureMainWeaponsComponent

    }

}