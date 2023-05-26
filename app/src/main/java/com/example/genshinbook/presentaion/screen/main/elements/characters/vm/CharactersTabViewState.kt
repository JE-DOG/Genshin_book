package com.example.genshinbook.presentaion.screen.main.elements.characters.vm

import com.example.genshinbook.presentaion.model.character.Character
data class CharactersTabViewState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val characters: List<Character> = emptyList()
)