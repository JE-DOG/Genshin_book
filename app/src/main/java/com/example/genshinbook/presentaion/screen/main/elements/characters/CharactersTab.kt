package com.example.genshinbook.presentaion.screen.main.elements.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.genshinbook.presentaion.screen.main.elements.characters.list_chararcters.ListCharacters
import com.example.genshinbook.presentaion.screen.main.elements.characters.vm.CharactersTabViewModel

@Composable
fun CharactersTab() {

    val viewModel = viewModel<CharactersTabViewModel>()

    Column() {

        ListCharacters(
            viewModel = viewModel,
            onClick = {
                //todo call detail screen characters
            }
        )
    }

}