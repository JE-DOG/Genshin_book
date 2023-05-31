package com.example.genshinbook.presentaion.screen.main.elements.characters.list_chararcters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.genshinbook.R
import com.example.genshinbook.core.elements.MyError
import com.example.genshinbook.core.elements.LoadingContent
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
                    onDownload = { character, isDownload ->
                        viewModel.characterDownload(
                            character = character,
                            isDownload = isDownload
                        )
                    }
                )

            }

        }

    } else {
        MyError(
            onRepeat = {
                viewModel.getAllInfoCharactersUseCase()
            }
        )
    }

}