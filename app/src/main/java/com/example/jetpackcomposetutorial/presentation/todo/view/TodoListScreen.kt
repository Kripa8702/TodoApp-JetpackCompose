package com.example.jetpackcomposetutorial.presentation.todo.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposetutorial.presentation.todo.composables.TodoInputBar
import com.example.jetpackcomposetutorial.presentation.todo.composables.TodoList
import com.example.jetpackcomposetutorial.presentation.todo.viewmodel.TodoViewModel
import com.example.jetpackcomposetutorial.ui.composables.BaseScreen
import kotlinx.coroutines.flow.flowOf
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TodoListScreen(
    viewModel: TodoViewModel = hiltViewModel()
) {
    val todoItems = viewModel.allTodos.collectAsState(initial = emptyList())
    BaseScreen(
        showBackButton = false,
        appBarTitle = "My Todos",
        content = {
            TodoList(
                todoItems = flowOf(
                    todoItems.value
                ),
                onItemClick = {},
                onDelete = { todo ->
                    viewModel.removeTodo(todo = todo)
                },

                )
        },
        bottomContent = {
            TodoInputBar { title ->
                viewModel.addTodo(title = title)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TodoListScreenPreview() {
    TodoListScreen(
    )
}