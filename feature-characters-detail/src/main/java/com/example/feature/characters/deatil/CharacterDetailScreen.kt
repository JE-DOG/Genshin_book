package com.example.feature.characters.deatil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.example.core.app.elements.Expandable
import com.example.core.app.ui.theme.BottomSheetBackground
import com.example.core.app.ui.theme.BottomSheetScrimColor
import com.example.core.app.ui.theme.BottomSheetShape
import com.example.core.app.ui.theme.ButtonTextColor
import com.example.core.app.ui.theme.DetailBackground
import com.example.core.R
import com.example.feature.characters.model.Character
import com.example.feature.characters.model.Constellation
import com.example.feature.characters.model.PassiveTalent
import com.example.feature.characters.model.SkillTalent
import com.example.core.app.model.vision.Vision
import com.example.genshinbook.presentaion.screen.detail.elements.bottom_sheet_type.elements.ConstellationsDetail
import com.example.genshinbook.presentaion.screen.detail.elements.bottom_sheet_type.elements.PassiveTalentDetail
import com.example.genshinbook.presentaion.screen.detail.elements.bottom_sheet_type.elements.SkillTalentDetail
import kotlinx.coroutines.launch

data class CharacterDetailScreen(
    private val character: Character
): Screen {

    private val vision = Vision.valueOf(character.vision_key)

    @OptIn(ExperimentalLayoutApi::class,
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
            sheetBackgroundColor = BottomSheetBackground,
            scrimColor = BottomSheetScrimColor,
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
                    .background(DetailBackground)
                    .fillMaxSize()
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                Row(
                    Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(text = character.name, fontSize = 30.sp, color = Color.White)
                    Image(painter = painterResource(vision.icon), contentDescription = "Card", Modifier.size(29.dp))
                }

                LazyRow(Modifier.padding(bottom = 10.dp)) {
                    items(character.rarity){
                        Image(painter = painterResource(id = R.drawable.ic_star), contentDescription = "star")
                    }
                }

                Text(
                    text = character.description,
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Text(text = "Weapon: ${character.weapon}", color = Color.White, fontSize = 20.sp)
                Text(text = "Nation: ${character.nation}", color = Color.White, fontSize = 20.sp)
                Text(text = "Constellation: ${character.constellation}", color = Color.White, fontSize = 20.sp)
                Text(text = "Affiliation: ${character.affiliation}", color = Color.White, fontSize = 20.sp)
                Text(text = "Birthday: ${character.birthday}", color = Color.White, fontSize = 20.sp)

                Expandable(headerText = "Skill talents") {
                    FlowRow(
                        Modifier.padding(vertical = 10.dp)
                    ) {

                        character.skillTalents.forEach {
                            OutlinedButton(
                                onClick = {
                                    bottomSheetType.value = it
                                    scope.launch {
                                        bottomSheetState.show()
                                    }
                                },
                                modifier = Modifier.padding(end = 10.dp)
                            ) {
                                Text(
                                    text = it.name,
                                    color = ButtonTextColor
                                )
                            }
                        }
                    }
                }

                Expandable(headerText = "Passive talents") {
                    FlowRow(
                        Modifier.padding(vertical = 10.dp)
                    ) {

                        character.passiveTalents.forEach {
                            OutlinedButton(
                                onClick = {
                                    bottomSheetType.value = it
                                    scope.launch {
                                        bottomSheetState.show()
                                    }
                                },
                                modifier = Modifier.padding(end = 10.dp)
                            ) {
                                Text(
                                    text = it.name,
                                    color = ButtonTextColor
                                )
                            }
                        }
                    }
                }

                Expandable(headerText = "Constellations") {
                    FlowRow(
                        Modifier.padding(vertical = 10.dp)
                    ) {

                        character.constellations.forEach {
                            OutlinedButton(
                                onClick = {
                                    bottomSheetType.value = it
                                    scope.launch {
                                        bottomSheetState.show()
                                    }
                                },
                                modifier = Modifier.padding(end = 10.dp)
                            ) {
                                Text(
                                    text = it.name,
                                    color = ButtonTextColor
                                )
                            }
                        }
                    }
                }

            }

        }

    }
}