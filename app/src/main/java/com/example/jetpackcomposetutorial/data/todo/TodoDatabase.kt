package com.example.jetpackcomposetutorial.data.todo

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetpackcomposetutorial.domain.model.Todo

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {
    abstract val todoDao: TodoDao
}