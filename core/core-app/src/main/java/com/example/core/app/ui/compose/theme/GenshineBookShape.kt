package com.example.core.app.ui.compose.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

val CardShape = RoundedCornerShape(12.dp)
val BottomSheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
val AlertShape = RoundedCornerShape(12.dp)