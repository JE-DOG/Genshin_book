package com.example.core.feature.compositions

import androidx.compose.runtime.compositionLocalOf
import com.example.core.feature.screen.ComposeMainScreensNavigation

val LocalScreensNavigation = compositionLocalOf<ComposeMainScreensNavigation> {
    throw IllegalArgumentException()
}