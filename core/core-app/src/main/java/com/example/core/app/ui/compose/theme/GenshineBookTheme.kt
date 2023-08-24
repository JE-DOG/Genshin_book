package com.example.core.app.ui.compose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.core.app.R

private val DarkColorPalette
    @Composable get()  = darkColors(
        primary = colorResource(id = R.color.black_blue),
        onPrimary = colorResource(id = R.color.medium_magenta),
        background = colorResource(id = R.color.signal_black),
        onBackground = Color.White,
)

private val LightColorPalette
    @Composable get() = lightColors(
        primary = colorResource(id = R.color.medium_magenta),
        onPrimary = colorResource(id = R.color.black_blue),
        background = Color.White,
        onBackground = colorResource(id = R.color.signal_black),
    )

@Composable
fun GenshinBookTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}