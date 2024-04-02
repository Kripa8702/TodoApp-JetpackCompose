package com.example.jetpackcomposetutorial.presentation.todo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposetutorial.domain.model.Todo
import com.example.jetpackcomposetutorial.domain.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val repository: TodoRepository,
) : ViewModel() {

    val allTodos = repository.getAllTodos()

    fun addTodo(title: String) =
        viewModelScope.launch {
            repository.insertTodo(
                Todo(
                    title = title,
                )
            )
        }

    fun toggleTodo(todo: Todo) = viewModelScope.launch {
        repository.insertTodo(todo.copy(isDone = !todo.isDone))
    }

    fun removeTodo(todo: Todo) = viewModelScope.launch {
        repository.deleteTodo(todo)
    }

}