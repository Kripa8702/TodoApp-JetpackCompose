package com.example.jetpackcomposetutorial.data.todo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey val id: Int? = null,
    val title: String,
    val description: String? = null,
    val isDone: Boolean = false,
)
