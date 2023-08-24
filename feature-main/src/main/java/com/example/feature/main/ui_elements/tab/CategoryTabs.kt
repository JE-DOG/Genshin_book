package com.example.feature.main.ui_elements.tab

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.feature.main.ui_elements.tab.elements.CategoryTab
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryTabs(category: List<String>,pagerState: PagerState) {

    val scope = rememberCoroutineScope()

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        edgePadding = 0.dp,
        containerColor = MaterialTheme.colors.primary,
        indicator = {
            TabRowDefaults.Indicator(
                Modifier.tabIndicatorOffset(it[pagerState.currentPage]),
                color = MaterialTheme.colors.onPrimary
            )
        },
        contentColor = MaterialTheme.colors.onPrimary
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