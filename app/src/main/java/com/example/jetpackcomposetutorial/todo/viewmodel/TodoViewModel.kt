package com.example.jetpackcomposetutorial.todo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposetutorial.data.todo.Todo
import com.example.jetpackcomposetutorial.data.todo.TodoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class TodoViewModel(
    private val repository: TodoRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    val allTodos = repository.allTodos

    fun addTodo(title: String, description: String?) =
        viewModelScope.launch(ioDispatcher) {
            repository.insertTodo(
                Todo(
                    title = title,
                    description = description
                )
            )
        }

    fun toggleTodo(todo: Todo) = viewModelScope.launch(ioDispatcher) {
        repository.insertTodo(todo.copy(isDone = !todo.isDone))
    }

    fun removeTodo(todo: Todo) = viewModelScope.launch(ioDispatcher) {
        repository.deleteTodo(todo)
    }

}