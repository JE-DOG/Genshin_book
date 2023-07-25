package com.example.genshinbook.presentaion.screen.detail.elements.bottom_sheet_type.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.feature.characters.model.SkillTalent

@Composable
fun SkillTalentDetail(skillTalent: SkillTalent) {

    Column{

        Text(
            text = skillTalent.name,
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier
                .padding(bottom = 15.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        
        Text(
            text = "Type: ${skillTalent.unlock}",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = skillTalent.description,
            color = Color.White,
            fontSize = 20.sp
        )

    }

}

@Composable
@Preview
fun SkillTalentDetailPreview() {

    SkillTalentDetail(
        SkillTalent(
            "While using Musou no Hitotachi and in the Musou Isshin state applied by Secret Art: Musou Shinsetsu, the Raiden Shogun's attacks ignore 60% of opponents's DEF.",
            "Pledge of Propriety",
            "",
            emptyList(),
            "4"
        )
    )

}