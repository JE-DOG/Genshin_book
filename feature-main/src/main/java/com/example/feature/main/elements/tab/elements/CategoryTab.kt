package com.example.feature.main.elements.tab.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryTab(selected: Boolean,label: String,onClick: () -> Unit = {}) {

    Tab(
        selected = selected,
        onClick = { onClick() },
        Modifier.padding(horizontal = 10.dp, vertical = 15.dp),
        unselectedContentColor = Color.White,
    ) {
        Text(text = label, fontSize = 15.sp)
    }

}

@Composable
@Preview(showBackground = true)
fun CategoryTabPreview() {

    CategoryTab(selected = true, label = "Characters")

}