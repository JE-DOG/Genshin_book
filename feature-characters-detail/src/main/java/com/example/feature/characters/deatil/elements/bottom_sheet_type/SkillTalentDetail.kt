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
import com.example.core.app.ui.compose.elements.base.Body1Text
import com.example.core.app.ui.compose.elements.base.Header1Text
import com.example.core.app.ui.compose.elements.base.Header2Text
import com.example.feature.characters.model.SkillTalent

@Composable
fun SkillTalentDetail(skillTalent: SkillTalent) {

    Column{

        Header1Text(
            text = skillTalent.name,
            modifier = Modifier
                .padding(bottom = 15.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        
        Header2Text(
            text = "Type: ${skillTalent.unlock}",
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Body1Text(
            text = skillTalent.description,
        )

    }

}

@Composable
@Preview(
    showSystemUi = true,
    showBackground = true
)
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