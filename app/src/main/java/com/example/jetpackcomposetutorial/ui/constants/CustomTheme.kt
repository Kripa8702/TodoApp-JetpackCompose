package com.example.jetpackcomposetutorial.ui.constants

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.jetpackcomposetutorial.ui.theme.Typography


private val DarkColorScheme = darkColorScheme(
    primary = DarkBlue500,
    secondary = Accent,
    background = DarkBackground,
    surface = DarkSurface,
    onPrimary = DarkBlue500,
    onSecondary = Color.Black,
    onBackground = WhiteColor,
    onSurface = WhiteColor
)

private val LightColorScheme = darkColorScheme(
    primary = DarkBlue500,
    secondary = Accent,
    background = LightBackground,
    surface = LightSurface ,
    onPrimary = DarkBlue500,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)


@Composable
fun CustomTheme(content: @Composable ()-> Unit){
    val isDarkMode = isSystemInDarkTheme()

    val colorScheme = if(isDarkMode) DarkColorScheme else LightColorScheme

    MaterialTheme(
       colorScheme = colorScheme,
        content = content,
        typography = Typography,
    )
}