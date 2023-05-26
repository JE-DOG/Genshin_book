package com.example.genshinbook.presentaion.screen.main.elements.characters

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.genshinbook.presentaion.screen.main.elements.characters.list_chararcters.ListCharacters
import com.example.genshinbook.presentaion.screen.main.elements.characters.vm.CharactersTabViewModel

@Composable
fun CharactersTab() {

    val viewModel = viewModel<CharactersTabViewModel>()

    Column(
        Modifier
            .fillMaxSize()
    ) {

        ListCharacters(
            viewModel = viewModel,
            onClick = {
                //todo call detail screen characters
            }
        )
    }

    LaunchedEffect(key1 = Unit){
        viewModel.getAllInfoCharactersUseCase()
    }

}