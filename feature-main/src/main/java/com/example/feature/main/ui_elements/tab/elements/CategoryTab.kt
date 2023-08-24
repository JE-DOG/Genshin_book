package com.example.feature.main.ui_elements.tab.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.app.ui.compose.elements.base.Body1Text

@Composable
fun CategoryTab(selected: Boolean,label: String,onClick: () -> Unit = {}) {

    Tab(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 15.dp),
        selected = selected,
        onClick = { onClick() },
    ) {
        Body1Text(
            text = label,
            color = if (selected)
                MaterialTheme.colors.onPrimary
            else
                MaterialTheme.colors.onBackground,
            fontWeight = if (selected)
                FontWeight.Bold
            else
                null
        )
    }

}

@Composable
@Preview(showBackground = true)
fun CategoryTabPreview() {

    CategoryTab(selected = true, label = "Characters")

}