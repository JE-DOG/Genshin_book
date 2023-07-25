package com.example.feature.characters.vm

import com.example.feature.characters.model.Character

data class CharactersTabViewState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isOffline: Boolean = false,
    val characters: MutableList<Character> = mutableListOf()
)