package com.example.jetpackcomposetutorial.ui.composables

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun CommonTextField(
    modifier: Modifier = Modifier,
    isPassword: Boolean = false,
    textFieldValue: MutableState<TextFieldValue>,
    onValueChange: (TextFieldValue) -> Unit = {},
    hintText: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    keyboardActions: KeyboardActions = KeyboardActions(),
    leadingIcon: ImageVector? = null,
) {
    val isVisible = remember { mutableStateOf(false) }

    val interactionSource = remember {
        MutableInteractionSource()
    }
    val isFocused = interactionSource.collectIsFocusedAsState()

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(),
        value = textFieldValue.value,
        textStyle = MaterialTheme.typography.bodyLarge,
        interactionSource = interactionSource,
        maxLines = 1,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(20.dp),
        leadingIcon = {
            if (leadingIcon != null)
                Icon(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    imageVector = leadingIcon,
                    tint = if (isFocused.value) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSurface.copy(
                        alpha = 0.4f
                    ),
                    contentDescription = ""
                )
        },

        visualTransformation = if (!isPassword || isVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (isVisible.value)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

            val description = if (isVisible.value) "Hide password" else "Show password"
            if (isPassword) {
                IconButton(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    onClick = { isVisible.value = !isVisible.value }) {
                    Icon(
                        imageVector = image,
                        tint = if (isFocused.value) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSurface.copy(
                            alpha = 0.4f
                        ),
                        contentDescription = description
                    )
                }
            }
        },
        placeholder = {
            Text(
                text = hintText,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
            )
        },

        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,

        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.secondary,
            unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedTextColor = MaterialTheme.colorScheme.secondary,
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
            cursorColor = MaterialTheme.colorScheme.onSurface,
        ),
    )
}