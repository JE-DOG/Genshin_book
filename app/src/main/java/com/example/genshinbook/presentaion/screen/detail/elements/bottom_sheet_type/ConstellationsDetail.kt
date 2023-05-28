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
import com.example.genshinbook.presentaion.model.character.Constellation

@Composable
fun ConstellationsDetail(
    constellation: Constellation
) {

    Column{

        Text(
            text = constellation.name,
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier
                .padding(bottom = 15.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Constellation level: ${constellation.level}",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = constellation.description,
            color = Color.White,
            fontSize = 20.sp
        )

    }

}