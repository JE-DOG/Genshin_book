package com.example.genshinbook.presentaion.screen.main.elements.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.core.elements.LoadingContent
import com.example.core.elements.OfflineModeNotification
import com.example.genshinbook.utils.ext.ViewModelStore
import com.example.genshinbook.presentaion.screen.detail.CharacterDetailScreen
import com.example.genshinbook.presentaion.screen.main.elements.characters.list_chararcters.ListCharacters
import com.example.genshinbook.presentaion.screen.main.elements.characters.vm.CharactersTabViewModel

@Composable
fun CharactersTab() {

    val viewModelStore = ViewModelStore()
    val viewModel = viewModel( initializer = { viewModelStore.characterTab } )
    val state = viewModel.state.observeAsState().value
    val navigator = LocalNavigator.currentOrThrow

    Column(
        Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (state!!.isOffline) {
            com.example.core.elements.OfflineModeNotification {
                viewModel.getAllCharacters()
            }
        }

        com.example.core.elements.LoadingContent(
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
                    navigator.push(CharacterDetailScreen(it))
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