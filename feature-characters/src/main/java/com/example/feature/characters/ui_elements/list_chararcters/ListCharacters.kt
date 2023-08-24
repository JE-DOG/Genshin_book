package com.example.feature.characters.ui_elements.list_chararcters

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import com.example.core.app.ui.compose.elements.GenshineBookError
import com.example.feature.characters.vm.CharactersTabViewModel
import com.example.feature.characters.ui_elements.list_chararcters.elements.CharacterCard
import com.example.feature.characters.model.Character

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
        GenshineBookError(
            onRepeat = {
                viewModel.getAllCharacters()
            }
        )
    }

}