@file:OptIn(ExperimentalFoundationApi::class)

package com.example.genshinbook.presentaion.screen.main.elements.list_chararcters

import android.service.autofill.OnClickAction
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.genshinbook.presentaion.model.character.Character
import com.example.genshinbook.presentaion.screen.main.elements.list_chararcters.elements.CharacterCard

@Composable
fun ListCharacters(list: List<Character>,onClick: () -> Unit) {

    LazyColumn{

        items(list){

            CharacterCard(character = it,onClick)

        }

    }

}