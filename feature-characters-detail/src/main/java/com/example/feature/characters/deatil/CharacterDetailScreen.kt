package com.example.feature.characters.deatil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedButton
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.example.core.app.ui.compose.elements.GenshineBookExpandable
import com.example.core.app.ui.compose.theme.BottomSheetShape
import com.example.core.app.R
import com.example.feature.characters.model.Character
import com.example.feature.characters.model.Constellation
import com.example.feature.characters.model.PassiveTalent
import com.example.feature.characters.model.SkillTalent
import com.example.core.app.model.vision.Vision
import com.example.core.app.ui.compose.elements.base.ButtonText
import com.example.core.app.ui.compose.elements.base.GenshineBookOutlinedButton
import com.example.core.app.ui.compose.elements.base.Header1Text
import com.example.core.app.ui.compose.elements.base.Header2Text
import com.example.core.app.ui.compose.elements.base.OutlinedButtonText
import com.example.genshinbook.presentaion.screen.detail.elements.bottom_sheet_type.elements.ConstellationsDetail
import com.example.genshinbook.presentaion.screen.detail.elements.bottom_sheet_type.elements.PassiveTalentDetail
import com.example.genshinbook.presentaion.screen.detail.elements.bottom_sheet_type.elements.SkillTalentDetail
import kotlinx.coroutines.launch

data class CharacterDetailScreen(
    private val character: Character
): Screen {

    private val vision = Vision.valueOf(character.vision_key)

    @OptIn(
        ExperimentalLayoutApi::class,
        ExperimentalMaterialApi::class
    )
    @Composable
    override fun Content() {

        val bottomSheetState = rememberModalBottomSheetState(
            ModalBottomSheetValue.Hidden
        )
        val scope = rememberCoroutineScope()
        val bottomSheetType = remember {
            mutableStateOf<Any?>(null)
        }


        ModalBottomSheetLayout(
            sheetShape = BottomSheetShape,
            sheetBackgroundColor = MaterialTheme.colors.background,
            scrimColor = colorResource(id = R.color.transparent_black),
            sheetContent = {

                Column(
                    Modifier
                        .wrapContentSize()
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

                    when(bottomSheetType.value){

                        is SkillTalent -> {
                            SkillTalentDetail(skillTalent = bottomSheetType.value as SkillTalent)
                        }
                        is PassiveTalent -> {
                            PassiveTalentDetail(bottomSheetType.value as PassiveTalent)
                        }
                        is Constellation -> {
                            ConstellationsDetail(bottomSheetType.value as Constellation)

                        }

                    }

                    Spacer(modifier = Modifier.height(50.dp))

                }

            },
            sheetState = bottomSheetState
        ) {
            Column(
                Modifier
                    .background(MaterialTheme.colors.background)
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Header1Text(text = character.name)
                    Image(painter = painterResource(vision.icon), contentDescription = "Card", Modifier.size(29.dp))
                }

                LazyRow(Modifier.padding(bottom = 10.dp)) {
                    items(character.rarity){
                        Image(painter = painterResource(id = R.drawable.ic_star), contentDescription = "star")
                    }
                }

                Header1Text(
                    text = character.description,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Header2Text(
                    text = "${stringResource(id = R.string.presentation_text_card_character_weapon)}: ${character.weapon}"
                )
                Header2Text(
                    text = "${stringResource(id = R.string.presentation_text_card_character_nation)}: ${character.nation}"
                )
                Header2Text(
                    text = "${stringResource(id = R.string.presentation_text_card_character_constellation)}: ${character.constellation}"
                )
                Header2Text(
                    text = "${stringResource(id = R.string.presentation_text_card_character_affiliation)}: ${character.affiliation}"
                )
                Header2Text(
                    text = "${stringResource(id = R.string.presentation_text_card_character_birthday)}: ${character.birthday}"
                )

                GenshineBookExpandable(headerText = "Skill talents") {
                    FlowRow(
                        Modifier.padding(vertical = 10.dp)
                    ) {

                        character.skillTalents.forEach {
                            GenshineBookOutlinedButton(
                                onClick = {
                                    bottomSheetType.value = it
                                    scope.launch {
                                        bottomSheetState.show()
                                    }
                                },
                                modifier = Modifier.padding(end = 10.dp)
                            ) {
                                OutlinedButtonText(
                                    text = it.name,
                                )
                            }
                        }
                    }
                }

                GenshineBookExpandable(headerText = "Passive talents") {
                    FlowRow(

                        Modifier.padding(vertical = 10.dp)
                    ) {

                        character.passiveTalents.forEach {
                            GenshineBookOutlinedButton(
                                onClick = {
                                    bottomSheetType.value = it
                                    scope.launch {
                                        bottomSheetState.show()
                                    }
                                },
                                modifier = Modifier.padding(end = 10.dp)
                            ) {
                                OutlinedButtonText(
                                    text = it.name
                                )
                            }
                        }
                    }
                }

                GenshineBookExpandable(headerText = "Constellations") {
                    FlowRow(
                        Modifier.padding(vertical = 10.dp)
                    ) {

                        character.constellations.forEach {
                            GenshineBookOutlinedButton(
                                onClick = {
                                    bottomSheetType.value = it
                                    scope.launch {
                                        bottomSheetState.show()
                                    }
                                },
                                modifier = Modifier.padding(end = 10.dp)
                            ) {
                                OutlinedButtonText(
                                    text = it.name
                                )
                            }
                        }
                    }
                }

            }

        }

    }
}