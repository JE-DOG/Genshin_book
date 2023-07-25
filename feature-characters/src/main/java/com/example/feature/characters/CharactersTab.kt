package com.example.feature.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.core.app.elements.LoadingContent
import com.example.core.app.elements.OfflineModeNotification
import com.example.core.feature.compositions.LocalScreensNavigation
import com.example.feature.characters.composition.LocalFeatureCharactersViewModel
import com.example.feature.characters.list_chararcters.ListCharacters

@Composable
fun CharactersTab() {

    val screens = LocalScreensNavigation.current
    val viewModel = LocalFeatureCharactersViewModel.current
    val state = viewModel.state.observeAsState().value
    val navigator = LocalNavigator.currentOrThrow

    Column(
        Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (state!!.isOffline) {
            OfflineModeNotification {
                viewModel.getAllCharacters()
            }
        }

        LoadingContent(
            isLoading = state.isLoading,
            isError = state.isError,
            onConfirm = {
                viewModel.getAllCharacters()
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
                    navigator.push(screens!!.characterDetail(it))
                }
            )
        }

        LaunchedEffect(key1 = Unit) {
            if (!state.isOffline && state.characters.isEmpty()){
                viewModel.getAllCharacters()
            }
        }
    }

}