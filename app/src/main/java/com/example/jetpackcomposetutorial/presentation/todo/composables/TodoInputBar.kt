package com.example.jetpackcomposetutorial.presentation.todo.composables

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial.R
import com.example.jetpackcomposetutorial.ui.constants.CustomTheme
import com.example.jetpackcomposetutorial.ui.constants.LargeDp
import com.example.jetpackcomposetutorial.ui.constants.WidgetRoundedCornerDp

@Composable
fun TodoInputBar(
    modifier: Modifier = Modifier,
    onItemAdd: (String) -> Unit = {}
) {
    //State Management
    val inputText = rememberSaveable { mutableStateOf("") }

    CustomTheme {
        Card(
            modifier = modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth()
                .height(70.dp)
                .imePadding(),
            shape = RoundedCornerShape(size = WidgetRoundedCornerDp),
            elevation = CardDefaults.cardElevation(defaultElevation = LargeDp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surface),
                verticalAlignment = Alignment.CenterVertically
                   ) {
                TextField(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(8f)
                        .wrapContentHeight(align = Alignment.CenterVertically),
                    textStyle = MaterialTheme.typography.bodyLarge,
                    maxLines = 1,
                    value = inputText.value,
                    placeholder = {
                        Text(
                            "Add new task...",
                        )
                    },
                    onValueChange = { newText ->
                        inputText.value = newText
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            onItemAdd(inputText.value)
                            inputText.value= ""
                        }
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedTextColor = MaterialTheme.colorScheme.onSurface,
                        cursorColor = MaterialTheme.colorScheme.onSurface,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                )
                FloatingActionButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(2f)
                        .padding(12.dp),
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.onSecondary,
                    elevation = FloatingActionButtonDefaults.elevation(
                        defaultElevation = LargeDp,
                        pressedElevation = LargeDp

                    ),
                    shape = RoundedCornerShape(size = WidgetRoundedCornerDp),
                    onClick = {
                        onItemAdd(inputText.value)
                        inputText.value= ""
                    }) {
                    Icon(
                        modifier = Modifier.padding(12.dp),
                        painter = painterResource(id = R.drawable.add),
                        contentDescription = "Add Todo",
                    )
                }

            }

        }
    }

}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TodoInputBarPreview() {
    TodoInputBar(modifier = Modifier)
}