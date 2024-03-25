package com.example.jetpackcomposetutorial.data.todo

import kotlinx.coroutines.flow.Flow

class TodoRepository (
    private val todoDao: TodoDao
) {

    val allTodos: Flow<List<Todo>> = todoDao.getAllTodos()

    suspend fun insertTodo(todo: Todo) {
        todoDao.insertTodo(todo)
    }

    suspend fun deleteTodo(todo: Todo) {
        todoDao.deleteTodo(todo)
    }

    suspend fun getTodoById(id: Int): Todo? {
        return todoDao.getTodoById(id)
    }
}