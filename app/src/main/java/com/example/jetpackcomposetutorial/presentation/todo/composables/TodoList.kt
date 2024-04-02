package com.example.jetpackcomposetutorial.presentation.todo.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial.domain.model.Todo
import com.example.jetpackcomposetutorial.ui.constants.CustomTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@Composable
fun TodoList(
    modifier: Modifier = Modifier,
    todoItems: Flow<List<Todo>> = flowOf(listOf()),
    onItemClick: (Todo) -> Unit = {},
    onDelete: (Todo) -> Unit = {},
) {
    //
    val todos = todoItems.collectAsState(initial = listOf()).value
    CustomTheme {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(18.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(todos) { item ->
                TodoItem(
                    todo = item,
                    onItemClick = onItemClick,
                    onDelete = onDelete
                )
            }
            item { Spacer(modifier = Modifier.height(60.dp)) }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodoListPreview() {
    TodoList(
        todoItems = flowOf(
            listOf(
                Todo(title = "Do Laundry"),
                Todo(title = "Do Laundry"),
                Todo(title = "Do Laundry"),
            )
        )
    )

}