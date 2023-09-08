package com.example.feature.characters.ui_elements.list_chararcters.elements

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.core.ext.isNotNull
import com.example.core.app.model.vision.Vision
import com.example.core.app.ui.compose.theme.CardShape
import kotlin.concurrent.thread
import com.example.feature.characters.model.Character
import com.example.core.app.R
import com.example.core.app.ui.compose.elements.base.GenshineBookProgressBar
import com.example.core.app.ui.compose.elements.base.Header1Text
import com.example.core.app.ui.compose.elements.base.Subtitle1Text
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterCard(
    character: Character,
    onItemClick: () -> Unit = {},
    onDownload: (Character) -> Flow<Boolean>
) {

    val vision = Vision.valueOf(character.vision_key)
    val coroutineScope = rememberCoroutineScope()

    Card(
        shape = CardShape,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.primary),
        modifier = Modifier.padding(bottom = 5.dp),
        onClick = { onItemClick() }
    ) {

        val isDownloaded = remember {
            mutableStateOf<Boolean?>(character.isDownload)
        }

        Column(
            Modifier.padding(20.dp)
        ) {

            Row(
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Header1Text(text = character.name)
                Image(painter = painterResource(vision.icon), contentDescription = "Card",Modifier.size(29.dp))
                Spacer(modifier = Modifier.weight(1f))
                if (isDownloaded.value.isNotNull()){
                    IconButton(onClick = {
                        coroutineScope.launch {
                            onDownload(character)
                                .onStart {
                                    isDownloaded.value = null
                                }
                                .collect {
                                    isDownloaded.value = it
                                }
                        }
                    }) {
                        Icon(
                            painter = painterResource(
                                id = if (isDownloaded.value!!)
                                    R.drawable.ic_delete
                                else
                                    R.drawable.ic_download
                            ),
                            contentDescription =
                            if (isDownloaded.value!!)
                                "delete card"
                            else
                                "save card",
                            tint = Color.Gray
                        )
                    }
                }else{
                    GenshineBookProgressBar()
                }

            }

            LazyRow(Modifier.padding(bottom = 10.dp)) {
                items(character.rarity){
                    Image(painter = painterResource(id = R.drawable.ic_star), contentDescription = "star")
                }
            }
            
            Subtitle1Text(text = "${stringResource(id = R.string.presentation_text_card_character_weapon)}: ${character.weapon}")
            Subtitle1Text(text = "${stringResource(id = R.string.presentation_text_card_character_nation)}: ${character.nation}")
            Subtitle1Text(text = "${stringResource(id = R.string.presentation_text_card_character_constellation)}: ${character.constellation}")

        }

    }

}
