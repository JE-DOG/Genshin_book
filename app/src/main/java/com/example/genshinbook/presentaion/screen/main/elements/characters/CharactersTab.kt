package com.example.genshinbook.presentaion.screen.main.elements.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.genshinbook.presentaion.screen.detail.CharacterDetailScreen
import com.example.genshinbook.presentaion.screen.main.elements.characters.list_chararcters.ListCharacters
import com.example.genshinbook.presentaion.screen.main.elements.characters.vm.CharactersTabViewModel

@Composable
fun CharactersTab() {

    val viewModel = viewModel<CharactersTabViewModel>()
    val navigator = LocalNavigator.currentOrThrow

    Column(
        Modifier
            .fillMaxSize()
    ) {

        ListCharacters(
            viewModel = viewModel,
            onClick = {
                navigator.push(CharacterDetailScreen(it))
            }
        )
    }

    LaunchedEffect(key1 = Unit){
        viewModel.getAllInfoCharactersUseCase()
    }

}