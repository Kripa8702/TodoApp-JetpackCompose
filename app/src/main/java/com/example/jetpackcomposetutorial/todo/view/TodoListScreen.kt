package com.example.jetpackcomposetutorial.todo.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposetutorial.data.todo.Todo
import com.example.jetpackcomposetutorial.todo.composables.TodoInputBar
import com.example.jetpackcomposetutorial.todo.composables.TodoList
import com.example.jetpackcomposetutorial.ui.composables.BaseScreen
import kotlinx.coroutines.flow.flowOf

@Composable
fun TodoListScreen(
    modifier: Modifier
) {
//    val db = Room.databaseBuilder(
//       applicationContext, TodoDatabase::class.java, "todo-db"
//    )

    BaseScreen(
        showBackButton = false,
        appBarTitle = "My Todos",
        content = {
            TodoList(
                todoItems = flowOf(
                    listOf(
                        Todo(title = "Do Laundry"),
                        Todo(title = "Make bed"),
                        Todo(title = "Search for jobs"),
                        Todo(title = "Leetcode"),
                    )
                ),
                onItemClick = {},
                onDelete = {},

                )
        },
        bottomContent = {
            TodoInputBar(
                onItemAdd = {}
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TodoListScreenPreview() {
    TodoListScreen(
        modifier = Modifier
    )
}