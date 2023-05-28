package com.example.genshinbook.presentaion.screen.detail.elements.bottom_sheet_type.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.genshinbook.presentaion.model.character.PassiveTalent

@Composable
fun PassiveTalentDetail(
    passiveTalent: PassiveTalent
) {

    Column{

        Text(
            text = passiveTalent.name,
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier
                .padding(bottom = 15.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Text(
            text = passiveTalent.description,
            color = Color.White,
            fontSize = 20.sp
        )

    }

}