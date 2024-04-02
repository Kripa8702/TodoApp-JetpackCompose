package com.example.jetpackcomposetutorial.domain.repository

import com.example.jetpackcomposetutorial.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    fun getAllTodos(): Flow<List<Todo>>

    suspend fun insertTodo(todo: Todo)

    suspend fun deleteTodo(todo: Todo)

    suspend fun getTodoById(id: Int): Todo?
}