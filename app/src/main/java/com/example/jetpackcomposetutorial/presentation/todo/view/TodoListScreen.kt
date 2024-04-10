package com.example.jetpackcomposetutorial.presentation.todo.view

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
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
            Column {
                TodoList(
                    modifier = Modifier.weight(10f),
                    todoItems = flowOf(
                        todoItems.value
                    ),
                    onItemClick = {
                        viewModel.toggleTodo(todo = it)
                    },
                    onDelete = { todo ->
                        viewModel.removeTodo(todo = todo)
                    },
                    )
                TodoInputBar{ title ->
                    viewModel.addTodo(title = title)
                }
            }
        }
//        bottomContent = {
//            TodoInputBar { title ->
//                viewModel.addTodo(title = title)
//            }
//        }
    )
}

@Preview(showBackground = true)
@Composable
fun TodoListScreenPreview() {
    TodoListScreen(
    )
}