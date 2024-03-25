package com.example.jetpackcomposetutorial.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.jetpackcomposetutorial.ui.constants.Accent
import com.example.jetpackcomposetutorial.ui.constants.DarkBlue500
import com.example.jetpackcomposetutorial.ui.constants.DarkBlue700
import com.example.jetpackcomposetutorial.ui.constants.WhiteColor

private val DarkColorScheme = darkColorScheme(
    primary = DarkBlue500,
    secondary = Accent,
    background = DarkBlue700,
    surface = DarkBlue500,
    onPrimary = DarkBlue500,
    onSecondary = Color.Black,
    onBackground = WhiteColor,
    onSurface = WhiteColor
)

private val LightColorScheme = lightColorScheme(
    primary = DarkBlue500,
    secondary = Accent,
    background = DarkBlue700,
    surface = DarkBlue500,
    onPrimary = DarkBlue500,
    onSecondary = Color.Black,
    onBackground = WhiteColor,
    onSurface = WhiteColor

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun JetpackComposeTutorialTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme =  if(darkTheme) {
        if (dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            DarkColorScheme
        } else {
            DarkColorScheme
        }
    } else {
        if (dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            LightColorScheme
        } else {
            LightColorScheme
        }

    }




    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}