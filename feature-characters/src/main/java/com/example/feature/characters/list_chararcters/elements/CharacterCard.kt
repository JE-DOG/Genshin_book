package com.example.feature.characters.list_chararcters.elements

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.ext.isNotNull
import com.example.core.app.model.vision.Vision
import com.example.core.app.ui.theme.CardBackground
import com.example.core.app.ui.theme.CardShape
import kotlin.concurrent.thread
import com.example.feature.characters.model.Character
import com.example.core.R


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
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        elevation = CardDefaults
            .cardElevation(pressedElevation = 500.dp),
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
                Text(text = character.name, fontSize = 25.sp, color = Color.White)
                Image(painter = painterResource(vision.icon), contentDescription = "Card",Modifier.size(29.dp))
                Spacer(modifier = Modifier.weight(1f))
                if (isDownloaded.value.isNotNull()){
                    IconButton(onClick = {
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
                    CircularProgressIndicator()
                }

            }

            LazyRow(Modifier.padding(bottom = 10.dp)) {
                items(character.rarity){
                    Image(painter = painterResource(id = R.drawable.ic_star), contentDescription = "star")
                }
            }
            
            Text(text = "Weapon: ${character.weapon}", color = Color.White, fontSize = 15.sp)
            Text(text = "Nation: ${character.nation}", color = Color.White, fontSize = 15.sp)
            Text(text = "Constellation: ${character.constellation}", color = Color.White, fontSize = 15.sp)

        }

    }

}
