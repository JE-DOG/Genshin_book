package com.example.genshinbook.presentaion.model.content_types

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.example.core.R
import com.example.genshinbook.presentaion.screen.empty.EmptyScreen
import com.example.genshinbook.presentaion.screen.main.elements.characters.CharactersTab

enum class ContentTypes(@StringRes val res: Int, val screen: @Composable () -> Unit) {

    CHARACTERS(
        res = R.string.ct_characters,
        {
            CharactersTab()
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