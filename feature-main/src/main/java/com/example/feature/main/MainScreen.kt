package com.example.feature.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.core.screen.Screen
import com.example.core.feature.compositions.LocalScreensNavigation
import com.example.feature.main.ui_elements.tab.CategoryTabs
import com.example.feature.main.model.content_types.ContentTypes
import com.example.feature.main.navigation.ComposeMainScreensNavigationImpl

class MainScreen : Screen{



    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    override fun Content() {
        val contentTypes = ContentTypes.values()
        val pagerState = rememberPagerState()

        CompositionLocalProvider(
            LocalScreensNavigation provides ComposeMainScreensNavigationImpl()
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                CategoryTabs(
                    category = contentTypes.map { stringResource(id = it.res) },
                    pagerState = pagerState
                )

                HorizontalPager(
                    contentTypes.size,
                    state = pagerState,
                    modifier = Modifier.weight(1f)
                ) {
                    contentTypes[it].screen()
                }
            }
        }
    }
}