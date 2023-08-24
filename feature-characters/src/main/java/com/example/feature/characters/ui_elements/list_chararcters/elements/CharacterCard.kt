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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterCard(
    character: Character,
    onItemClick: () -> Unit = {},
    onDownload: (Character) -> Unit
) {

    val vision = Vision.valueOf(character.vision_key)

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
                        // TODO: Clear it trash solution
                        isDownloaded.value = null
                        onDownload(character)
                        thread {
                            Thread.sleep(2000)
                            isDownloaded.value = character.isDownload
                        }
                        Log.d("RememberTest", isDownloaded.value.toString())
                    }) {
                        if (isDownloaded.value!!) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_delete),
                                contentDescription = "delete card",
                                Modifier.size(25.dp),
                                tint = Color.Gray
                            )
                        } else {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_download),
                                contentDescription = "save card",
                                Modifier.size(25.dp),
                                tint = Color.Gray
                            )
                        }
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
            
            Subtitle1Text(text = "Weapon: ${character.weapon}")
            Subtitle1Text(text = "Nation: ${character.nation}")
            Subtitle1Text(text = "Constellation: ${character.constellation}")

        }

    }

}
