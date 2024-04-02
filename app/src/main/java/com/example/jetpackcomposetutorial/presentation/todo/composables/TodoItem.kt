package com.example.jetpackcomposetutorial.presentation.todo.composables

import AnimatedCheckbox
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial.R
import com.example.jetpackcomposetutorial.domain.model.Todo
import com.example.jetpackcomposetutorial.ui.constants.CustomTheme
import com.example.jetpackcomposetutorial.ui.constants.MediumDp

@Composable
fun TodoItem(
    todo: Todo,
    onItemClick: (Todo) -> Unit = {},
    onDelete: (Todo) -> Unit = {},
) {
    val textDecoration = if (todo.isDone) TextDecoration.LineThrough else null

    val iconId = if (todo.isDone) R.drawable.checked else R.drawable.unchecked

    val isCheck = remember{ mutableStateOf(false) }

    CustomTheme {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(size = 50.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable(
                        interactionSource = remember {
                            MutableInteractionSource()
                        }, indication = rememberRipple(bounded = true)
                    ) {
                        onItemClick(todo)
                    }, verticalAlignment = Alignment.CenterVertically

            ) {
                AnimatedCheckbox(
                    modifier = Modifier.padding(10.dp),
                )
                Text(
                    text = todo.title,
                    modifier = Modifier.weight(8f),
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    textDecoration = textDecoration,

                    color = MaterialTheme.colorScheme.onSecondary,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    onClick = { onDelete(todo) }, modifier = Modifier.weight(1.5f)
                ) {
                    Icon(
                        modifier = Modifier.size(22.dp),
                        painter = painterResource(id = R.drawable.delete),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Light Theme")
@Composable
fun TodoItemPreviewLight(
) {
    Column(
        modifier = Modifier.padding(MediumDp), verticalArrangement = Arrangement.spacedBy(MediumDp)
    ) {
        TodoItem(todo = Todo(title = "Work from home"))
        TodoItem(todo = Todo(title = "Work from home"))
    }
}

@Preview(showBackground = true, name = "Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TodoItemPreviewDark(
) {
    Column(
        modifier = Modifier.padding(MediumDp), verticalArrangement = Arrangement.spacedBy(MediumDp)
    ) {
        TodoItem(todo = Todo(title = "Work from home"))
        TodoItem(todo = Todo(title = "Work from home"))
    }
}