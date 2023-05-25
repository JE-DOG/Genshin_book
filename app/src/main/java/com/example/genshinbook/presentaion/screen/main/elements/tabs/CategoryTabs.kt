package com.example.genshinbook.presentaion.screen.main.elements.tabs

import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.genshinbook.presentaion.screen.main.elements.tabs.elements.CategoryTab

@Composable
fun CategoryTabs(category: List<String>) {

    val selected = remember {
        mutableStateOf(0)
    }

    ScrollableTabRow(
        selectedTabIndex = selected.value,
        edgePadding = 0.dp,
        containerColor = Color.Black
    ) {

        category.forEachIndexed{ index, label ->

            CategoryTab(
                selected = index == selected.value,
                label = label,
                onClick = { selected.value = index }
            )

        }

    }

}

@Composable
@Preview(showBackground = true)
fun CategoryTabsPreview() {

    CategoryTabs(category = listOf(
        "Персонажи",
        "Персонажи",
        "Персонажи",
        "Персонажи",
        "Артефакты",
        "Артефакты",
        "Артефакты",
        "Артефакты",
        "Артефакты",
    ))

}