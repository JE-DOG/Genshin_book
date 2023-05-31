package com.example.genshinbook.presentaion.screen.main.elements.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.genshinbook.R
import com.example.genshinbook.core.elements.LoadingContent
import com.example.genshinbook.core.elements.OfflineModeNotification
import com.example.genshinbook.presentaion.screen.detail.CharacterDetailScreen
import com.example.genshinbook.presentaion.screen.main.elements.characters.list_chararcters.ListCharacters
import com.example.genshinbook.presentaion.screen.main.elements.characters.vm.CharactersTabViewModel

@Composable
fun CharactersTab() {

    val viewModel = viewModel<CharactersTabViewModel>()
    val state = viewModel.state.observeAsState().value
    val navigator = LocalNavigator.currentOrThrow

    Column(
        Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (state!!.isOffline) {
            OfflineModeNotification {
                viewModel.getAllInfoCharactersUseCase()
            }
        }

        LoadingContent(
            isLoading = state.isLoading,
            isError = state.isError,
            onConfirm = {
                viewModel.getAllInfoCharactersUseCase()
            },
            onDismiss = {
                viewModel.changeState(
                    state.copy(
                        isError = false
                    )
                )
            }
        ) {

            ListCharacters(
                viewModel = viewModel,
                onClick = {
                    navigator.push(CharacterDetailScreen(it))
                }
            )
        }

        LaunchedEffect(key1 = Unit) {
            viewModel.getAllInfoCharactersUseCase()
        }
    }

}