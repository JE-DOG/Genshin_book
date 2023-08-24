package com.example.feature.characters.di.component

import androidx.compose.runtime.Composable
import com.example.feature.characters.di.deps.FeatureCharactersDeps
import com.example.feature.characters.di.module.DataModule
import com.example.feature.characters.vm.CharactersTabViewModel
import dagger.Component

@FeatureCharactersScope
@Component(
    modules = [
        DataModule::class
    ],
    dependencies = [
        FeatureCharactersDeps::class
    ]
)
interface FeatureCharactersComponent {

    val charactersTabViewModelFactory: CharactersTabViewModel.Factory

    @Component.Factory
    interface Factory {

        fun create(
            deps: FeatureCharactersDeps
        ): FeatureCharactersComponent

    }

}