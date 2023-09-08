package com.example.feature.main.weapons.ui_elements.list_weapons.elements

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import com.example.core.app.R
import com.example.core.app.model.vision.Vision
import com.example.core.app.model.weapon.WeaponType
import com.example.core.app.ui.compose.elements.base.GenshineBookProgressBar
import com.example.core.app.ui.compose.elements.base.Header1Text
import com.example.core.app.ui.compose.elements.base.Subtitle1Text
import com.example.core.app.ui.compose.theme.CardShape
import com.example.core.ext.isNotNull
import com.example.feature.main.weapons.model.WeaponPresentation
import io.reactivex.Completable
import java.util.Locale
import kotlin.concurrent.thread

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeaponCard(
    weapon: WeaponPresentation,
    onItemClick: (resIcon: Int) -> Unit = {},
    onDownload: (WeaponPresentation) -> Completable
) {

    val weaponType = WeaponType.valueOf(weapon.type.uppercase())

    Card(
        shape = CardShape,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.primary),
        modifier = Modifier.padding(bottom = 5.dp),
        onClick = { onItemClick(weaponType.resIcon) }
    ) {

        val isDownloaded = remember {
            mutableStateOf<Boolean?>(weapon.isDownloaded)
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
                Header1Text(
                    text = weapon.name,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Image(painter = painterResource(weaponType.resIcon), contentDescription = "Card", Modifier.size(29.dp))
                Spacer(modifier = Modifier.weight(1f))
                if (isDownloaded.value.isNotNull()){
                    IconButton(onClick = {
                        isDownloaded.value = null
                        onDownload(weapon)
                            .doOnComplete {
                                isDownloaded.value = weapon.isDownloaded
                            }
                            .subscribe()
                    }) {
                        Icon(
                            painter = if (!isDownloaded.value!!) painterResource(id = R.drawable.ic_download) else painterResource(id = R.drawable.ic_delete),
                            contentDescription = if (!isDownloaded.value!!) "save card" else "delete card",
                            Modifier.size(25.dp),
                            tint = Color.Gray
                        )
                    }
                }else{
                    GenshineBookProgressBar()
                }

            }

            LazyRow(Modifier.padding(bottom = 10.dp)) {
                items(weapon.rarity){
                    Image(painter = painterResource(id = R.drawable.ic_star), contentDescription = "star")
                }
            }

            Subtitle1Text(text = "${stringResource(id = R.string.presentation_text_card_weapon_base_atk)}: ${weapon.baseAttack}")
            Subtitle1Text(text = "${stringResource(id = R.string.presentation_text_card_weapon_sub_stat)}: ${weapon.subStat}")
            Subtitle1Text(text = "${stringResource(id = R.string.presentation_text_card_weapon_location)}: ${weapon.location}")

        }

    }

}