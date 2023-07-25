package com.example.feature.characters.composition

import androidx.compose.runtime.compositionLocalOf
import com.example.feature.characters.vm.CharactersTabViewModel

val LocalFeatureCharactersViewModel = compositionLocalOf<CharactersTabViewModel> {
    throw IllegalArgumentException()
}