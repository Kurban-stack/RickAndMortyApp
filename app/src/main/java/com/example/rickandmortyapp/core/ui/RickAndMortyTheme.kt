package com.example.rickandmortyapp.core.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val DarkGray = Color(0xFF121212)
val LightGray = Color(0xFFBB86FC)
val Purple = Color(0xFF6200EE)
val Teal = Color(0xFF03DAC5)
val White = Color(0xFFFFFFFF)

val LightColorPalette = lightColorScheme(
    primary = Purple,
    onPrimary = White,
    secondary = Teal,
    onSecondary = White,
    background = DarkGray,
    onBackground = White,
    surface = LightGray,
    onSurface = DarkGray
)

val AppTypography = Typography(
    titleLarge = TextStyle(
        fontSize = 31.sp,
        fontWeight = FontWeight.Bold,
        color = White
    ),
    titleMedium = TextStyle(
        fontSize = 21.sp,
        fontWeight = FontWeight.Bold,
        color = White
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = White
    )
)

@Composable
fun RickAndMortyTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorPalette,
        typography = AppTypography,
        content = content
    )
}