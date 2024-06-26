package com.example.jetpackcomposetutorial.ui.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    title: String,
    actions: @Composable RowScope.() -> Unit = {},
    showBackButton: Boolean = true,
    onPop : () -> Unit = {}
) {
    TopAppBar(
        modifier = Modifier.padding(top = 8.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = MaterialTheme.colorScheme.onBackground
        ),
        title = {
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.W500
                ),
            )
        },

        navigationIcon = {
            if (showBackButton) {
                IconButton(
                    modifier = Modifier.padding(horizontal = 10.dp).height(20.dp),
                    onClick = onPop
                ) {
                    Icon(
                        Icons.Rounded.ArrowBackIosNew,
                        modifier = Modifier.size(32.dp),
                        contentDescription = null)
                }
            }
        },
        actions = actions
    )
}