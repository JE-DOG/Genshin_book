package com.example.feature.main.weapons.ui_elements.list_weapons

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.core.app.ui.compose.elements.GenshineBookError
import com.example.feature.main.weapons.model.WeaponPresentation
import com.example.feature.main.weapons.ui_elements.list_weapons.elements.WeaponCard
import com.example.feature.main.weapons.vm.WeaponsTabViewModel
import com.example.feature.main.weapons.vm.WeaponsTabViewState

@SuppressLint("CheckResult")
@Composable
fun WeaponsList(
    viewModel: WeaponsTabViewModel,
    state: WeaponsTabViewState,
    onClick: (WeaponPresentation,Int) -> Unit
) {
    if (state.weapons.isNotEmpty()) {

        LazyColumn(
            contentPadding = PaddingValues(10.dp)
        ) {

            items(state.weapons) {

                WeaponCard(
                    weapon = it,
                    onItemClick = { resIcon ->
                        onClick(it,resIcon)
                    },
                    onDownload = { weapon ->
                        if (weapon.isDownloaded){
                            viewModel.deleteWeapon(
                                weapon = weapon
                            )
                        }else {
                            viewModel.saveWeapon(
                                weapon = weapon
                            )
                        }
                        
                    }
                )

            }

        }

    } else {
        GenshineBookError(
            onRepeat = {
                viewModel.getAllWeapons()
            }
        )
    }

}