package com.example.genshinbook.presentaion.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.genshinbook.data.network.repository.characters.CharactersNetworkImpl
import com.example.genshinbook.data.repository.characters.CharactersRepositoryImpl
import com.example.genshinbook.domain.usecase.characters.GetAllNameCharactersUseCase
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun TestScreen() {

    val charactersNetwork = CharactersNetworkImpl()
    val charactersRepository = CharactersRepositoryImpl(charactersNetwork)
    val getAllNameCharactersUseCase =GetAllNameCharactersUseCase(charactersRepository)

    val text = remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    scope.launch {
        text.value = getAllNameCharactersUseCase.execute().toString()
    }


    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        Text(text = text.value)

    }

}