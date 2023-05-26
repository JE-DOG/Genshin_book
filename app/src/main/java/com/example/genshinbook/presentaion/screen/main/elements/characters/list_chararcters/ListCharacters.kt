@file:OptIn(ExperimentalFoundationApi::class)

package com.example.genshinbook.presentaion.screen.main.elements.characters.list_chararcters

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.genshinbook.core.elements.LoadingContent
import com.example.genshinbook.presentaion.screen.main.elements.characters.vm.CharactersTabViewModel
import com.example.genshinbook.presentaion.screen.main.elements.characters.list_chararcters.elements.CharacterCard

@Composable
fun ListCharacters(viewModel: CharactersTabViewModel, onClick: () -> Unit) {

    val state = viewModel.state.value

    LoadingContent(
        isLoading = state!!.isLoading,
        isError = state.isError,
        onConfirm = {
            viewModel.getAllInfoCharactersUseCase()
        },
        onDismiss = {
            viewModel.changeErrorState()
        }
    ) {

        LazyColumn{

            items(state.characters){

                CharacterCard(character = it,onClick)

            }

        }

    }

}