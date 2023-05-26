package com.example.genshinbook.presentaion.screen.main

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.genshinbook.R
import com.example.genshinbook.presentaion.model.content_types.ContentTypes
import com.example.genshinbook.presentaion.screen.main.elements.tabs.CategoryTabs

@SuppressLint("ResourceType")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen() {

    val contentTypes = ContentTypes.values()
    val pagerState = rememberPagerState()

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
            state = pagerState
        ) {
            contentTypes[it].screen
        }
    }

}