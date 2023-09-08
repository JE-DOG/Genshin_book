package com.example.feature.main.weapons

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.core.app.R
import com.example.core.app.ui.compose.elements.GenshineBookExpandable
import com.example.core.app.ui.compose.elements.GenshineBookLoadingContent
import com.example.core.app.ui.compose.elements.GenshineBookOfflineModeNotification
import com.example.core.app.ui.compose.elements.base.Body1Text
import com.example.core.app.ui.compose.elements.base.Header1Text
import com.example.core.app.ui.compose.elements.base.Header2Text
import com.example.core.app.ui.compose.theme.BottomSheetShape
import com.example.core.ext.isNotNull
import com.example.feature.main.weapons.composition.LocalFeatureWeaponViewModel
import com.example.feature.main.weapons.model.WeaponPresentation
import com.example.feature.main.weapons.ui_elements.list_weapons.WeaponsList
import com.example.feature.main.weapons.vm.WeaponsTabViewState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("CheckResult")
@Composable
fun WeaponsTab() {

    val coroutineScope = rememberCoroutineScope()
    val bottomSheetContent = remember {
        mutableStateOf<Pair<WeaponPresentation,Int>?>(null)
    }
    val bottomSheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden
    )
    val viewModel = LocalFeatureWeaponViewModel.current
    val state = viewModel.state
        .observeAsState()
        .value!!

    ModalBottomSheetLayout(
        sheetShape = BottomSheetShape,
        scrimColor = colorResource(id = R.color.transparent_black)      ,
        sheetState = bottomSheetState,
        sheetContent = {
            if (bottomSheetContent.value.isNotNull()){
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .verticalScroll(rememberScrollState())
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_drag_handle),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(vertical = 15.dp)
                    )

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Header1Text(text = bottomSheetContent.value!!.first.name)
                        Image(
                            painter = painterResource(bottomSheetContent.value!!.second),
                            contentDescription = "Card",
                            Modifier.size(29.dp)
                        )
                    }

                    LazyRow(Modifier.padding(bottom = 10.dp)) {
                        items(bottomSheetContent.value!!.first.rarity) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_star),
                                contentDescription = "star"
                            )
                        }
                    }

                    Header2Text(
                        text = "${stringResource(id = R.string.presentation_text_card_weapon_base_atk)}: ${bottomSheetContent.value!!.first.baseAttack}"
                    )
                    Header2Text(
                        text = "${stringResource(id = R.string.presentation_text_card_weapon_sub_stat)}: ${bottomSheetContent.value!!.first.subStat}"
                    )
                    Header2Text(
                        text = "${stringResource(id = R.string.presentation_text_card_weapon_location)}: ${bottomSheetContent.value!!.first.location}"
                    )
                    Header2Text(
                        text = "${stringResource(id = R.string.presentation_text_card_weapon_ascension_material)}: ${bottomSheetContent.value!!.first.ascensionMaterial}"
                    )

                    GenshineBookExpandable(headerText = "Skill talents") {
                        Body1Text(text = bottomSheetContent.value!!.first.passiveDesc)
                    }
                }
            }
        }
    ) {

        Column(
            Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (state.isOffline) {
                GenshineBookOfflineModeNotification {
                    viewModel.getAllWeapons()
                }
            }

            GenshineBookLoadingContent(
                isLoading = state.isLoading,
                isError = state.isError,
                onConfirm = {
                    viewModel.getAllWeapons()
                },
                onDismiss = {
                    viewModel.changeState(
                        state.copy(
                            isError = false
                        )
                    )
                }
            ) {

                WeaponsList(
                    viewModel = viewModel,
                    state = state,
                    onClick = { weaponPresentation, resIcon ->
                        bottomSheetContent.value = Pair(weaponPresentation, resIcon)
                        coroutineScope.launch {
                            bottomSheetState.show()
                        }
                    }
                )
            }

            LaunchedEffect(key1 = Unit) {
                if (!state.isOffline && state.weapons.isEmpty()) {
                    viewModel.getAllWeapons()
                }
            }
        }
    }

}