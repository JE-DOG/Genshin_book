package com.example.genshinbook.presentaion.screen.main.elements.tabs

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.genshinbook.presentaion.screen.main.elements.tabs.elements.CategoryTab
import com.example.genshinbook.presentaion.ui.theme.CardBackground
import com.example.genshinbook.presentaion.ui.theme.TabSelectedColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryTabs(category: List<String>,pagerState: PagerState) {

    val scope = rememberCoroutineScope()

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        edgePadding = 0.dp,
        containerColor = CardBackground,
        indicator = {
            TabRowDefaults.Indicator(
                Modifier.tabIndicatorOffset(it[pagerState.currentPage]),
                color = TabSelectedColor
            )
        },
        contentColor = TabSelectedColor
    ) {

        category.forEachIndexed{ index, label ->

            CategoryTab(
                selected = index == pagerState.currentPage,
                label = label,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )

        }

    }

}