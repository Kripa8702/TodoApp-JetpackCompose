package com.example.jetpackcomposetutorial.ui.composables

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun CommonTextField(
    modifier: Modifier = Modifier,
    isPassword: Boolean = false,
    textFieldValue: MutableState<TextFieldValue>,
    onValueChange: (TextFieldValue) -> Unit = {},
    hintText: String = "",
    imeAction: ImeAction = ImeAction.Done,
    leadingIcon: ImageVector? = null,
) {
    var isVisible = remember { mutableStateOf(false) }

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
                    //make secondary color when textfield focussed
                    tint = if(isFocused.value) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f),
                    contentDescription = "")
        },
        trailingIcon = {
//                       if(isPassword){
//                            Icon(
//                                 imageVector = if(isVisible.value) Icons.Filled.vis else Icons.Default.VisibilityOff,
//                                 contentDescription = "Toggle Password Visibility",
//                                 tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f),
//                                 modifier = Modifier.padding(horizontal = 20.dp).padding(end = 10.dp).height(20.dp)
//                            )
//                       }
        },
        placeholder = {
            Text(
                text = hintText,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
            )
        },
        keyboardOptions = KeyboardOptions(imeAction = imeAction),

        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.secondary,
            unfocusedBorderColor = Color.Transparent,
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedTextColor = MaterialTheme.colorScheme.secondary,
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
            cursorColor = MaterialTheme.colorScheme.onSurface,
        ),
    )
}