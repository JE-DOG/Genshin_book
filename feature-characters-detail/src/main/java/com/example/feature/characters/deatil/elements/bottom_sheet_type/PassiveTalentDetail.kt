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
import com.example.core.app.ui.compose.elements.base.Body1Text
import com.example.core.app.ui.compose.elements.base.Header1Text
import com.example.feature.characters.model.PassiveTalent

@Composable
fun PassiveTalentDetail(
    passiveTalent: PassiveTalent
) {

    Column{

        Header1Text(
            text = passiveTalent.name,
            modifier = Modifier
                .padding(bottom = 15.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Body1Text(
            text = passiveTalent.description,
        )

    }

}