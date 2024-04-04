package com.example.jetpackcomposetutorial.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial.ui.constants.CustomTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BaseScreen(
    content: @Composable () -> Unit,
    bottomContent: @Composable () -> Unit = {},
    showBackButton: Boolean = true,
    appBarTitle: String = "",
    actions: @Composable RowScope.() -> Unit = {},
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    CustomTheme {
        Scaffold(
            modifier = Modifier
                .clickable(
                    interactionSource = remember {
                        MutableInteractionSource()
                    },
                    indication = null
                ) {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                },
            topBar = {
                CustomTopAppBar(
                    showBackButton = showBackButton,
                    title = appBarTitle,
                    actions = actions,
                )
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .imePadding()
                    .padding(innerPadding),
                contentAlignment = Alignment.TopStart // Align content to top
            ) {
                Box(
                    modifier = Modifier.padding(horizontal = 20.dp)
                ) {
                    content()
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 5.dp),
                ) {
                    bottomContent()
                }
            }
        }
    }
}