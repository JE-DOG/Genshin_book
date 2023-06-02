package com.example.genshinbook.presentaion.screen.main.elements.characters.list_chararcters

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import com.example.genshinbook.core.elements.MyError
import com.example.genshinbook.presentaion.screen.main.elements.characters.vm.CharactersTabViewModel
import com.example.genshinbook.presentaion.screen.main.elements.characters.list_chararcters.elements.CharacterCard
import com.example.genshinbook.presentaion.model.character.Character

@Composable
fun ListCharacters(viewModel: CharactersTabViewModel, onClick: (Character) -> Unit,) {

    val state = viewModel.state.observeAsState().value

    if (state!!.characters.isNotEmpty()) {

        LazyColumn(
            contentPadding = PaddingValues(10.dp)
        ) {

            items(state.characters) {

                CharacterCard(
                    character = it,
                    onItemClick = {
                        onClick(it)
                    },
                    onDownload = { character ->
                        viewModel.characterDownload(
                            character = character
                        )
                    }
                )

            }

        }

    } else {
        MyError(
            onRepeat = {
                viewModel.getAllCharacters()
            }
        )
    }

}