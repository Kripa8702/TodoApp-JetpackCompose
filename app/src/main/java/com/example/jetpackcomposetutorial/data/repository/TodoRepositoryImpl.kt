package com.example.jetpackcomposetutorial.data.repository

import com.example.jetpackcomposetutorial.data.dao.TodoDao
import com.example.jetpackcomposetutorial.domain.model.Todo
import com.example.jetpackcomposetutorial.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(
    private val todoDao: TodoDao
) : TodoRepository{
    override fun getAllTodos(): Flow<List<Todo>> {
        return todoDao.getAllTodos()
    }

    override suspend fun insertTodo(todo: Todo) {
        todoDao.insertTodo(todo)
    }

    override suspend fun deleteTodo(todo: Todo) {
        todoDao.deleteTodo(todo)
    }

    override suspend fun getTodoById(id: Int): Todo? {
        return todoDao.getTodoById(id)
    }

}