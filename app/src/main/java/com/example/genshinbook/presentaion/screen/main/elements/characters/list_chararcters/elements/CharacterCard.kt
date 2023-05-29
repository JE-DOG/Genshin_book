package com.example.genshinbook.presentaion.screen.main.elements.characters.list_chararcters.elements

import android.service.autofill.OnClickAction
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.genshinbook.R
import com.example.genshinbook.presentaion.model.character.Character
import com.example.genshinbook.presentaion.model.vision.Vision
import com.example.genshinbook.presentaion.ui.theme.CardBackground
import com.example.genshinbook.presentaion.ui.theme.CardShape

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterCard(character: Character,onClick: () -> Unit = {}) {

    val vision = Vision.valueOf(character.vision_key)

    Card(
        shape = CardShape,
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        elevation = CardDefaults
            .cardElevation(pressedElevation = 500.dp),
        modifier = Modifier.padding(bottom = 5.dp),
        onClick = { onClick() }
    ) {

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
                if (character.isDownload){
                    Image(painter = painterResource(id = R.drawable.ic_delete), contentDescription = "delete card")
                }else{
                    Image(painter = painterResource(id = R.drawable.ic_download), contentDescription = "save card")
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

@Preview(showBackground = true)
@Composable
fun CharacterCardPreview() {

    val character = Character(
        "Inazuma City",
        "2000-12-01",
        "Imperatrix Umbrosa",
        emptyList(),
        "Her Excellency, the Almighty, Narukami Ogosho, who promised the people of Inazuma an unchanging Eternity",
        "Raiden Shogun",
        "Inazuma",
        emptyList(),
        5,
        emptyList(),
        "Plane of Euthymia",
        "Electro",
        "ELECTRO",
        "Polearm",
        "POLEARM"
    )

    LazyColumn{

        items(10){
            CharacterCard(character = character,{})
        }

    }

}