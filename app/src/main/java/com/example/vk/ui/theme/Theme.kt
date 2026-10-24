package com.example.vk.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = VkBlueDark,
    onPrimary = Color.White,
    secondaryContainer = VkBlueContainerDark,
    onSecondaryContainer = OnVkBlueContainerDark,
)

private val LightColorScheme = lightColorScheme(
    primary = VkBlue,
    onPrimary = Color.White,
    secondaryContainer = VkBlueContainer,
    onSecondaryContainer = OnVkBlueContainer,
    background = Color.White,
    surface = Color.White,
)

// Динамические цвета намеренно не используются: тулбар должен быть в фирменном акцентном цвете
@Composable
fun VKTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = Typography,
        content = content
    )
}
