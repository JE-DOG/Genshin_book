package com.example.feature.main.model.content_types

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.core.app.R
import com.example.feature.characters.CharactersTab
import com.example.feature.characters.composition.LocalFeatureCharactersViewModel
import com.example.feature.characters.di.component.DaggerFeatureCharactersComponent
import com.example.feature.characters.di.deps.FeatureCharactersDepsStore
import com.example.feature.characters.vm.CharactersTabViewModel
import com.example.feature.main.empty.EmptyScreen

enum class ContentTypes(@StringRes val res: Int, val screen: @Composable () -> Unit) {

    CHARACTERS(
        res = R.string.ct_characters,
        {
            val charactersComponent = DaggerFeatureCharactersComponent
                .factory()
                .create(FeatureCharactersDepsStore.deps)

            val charactersTabViewModel = viewModel(
                factory = charactersComponent.charactersTabViewModelFactory,
                modelClass = CharactersTabViewModel::class.java
            )

            CompositionLocalProvider(
                LocalFeatureCharactersViewModel provides charactersTabViewModel
            ) {
                CharactersTab()
            }
        }
    ),
    WEAPONS(
        res = R.string.ct_weapons,
        {
            EmptyScreen()
        }
    ),
    BOSS(
        res = R.string.ct_boss,
        {
            EmptyScreen()
        }
    ),
    ENEMIES(
        res = R.string.ct_enemies,
        {
            EmptyScreen()
        }
    ),
    ELEMENTS(
        res = R.string.ct_elements,
        {
            EmptyScreen()
        }
    ),
    MATERIALS(
        res = R.string.ct_materials,
        {
            EmptyScreen()
        }
    ),
    ARTIFACTS(
        res = R.string.ct_artifacts,
        {
            EmptyScreen()
        }
    ),
    CONSUMABLES(
        res = R.string.ct_consumables,
        {
            EmptyScreen()
        }
    ),
    NATIONS(
        res = R.string.ct_nations,
        {
            EmptyScreen()
        }
    ),
    DOMAINS(
        res = R.string.ct_domains,
        {
            EmptyScreen()
        }
    )

}