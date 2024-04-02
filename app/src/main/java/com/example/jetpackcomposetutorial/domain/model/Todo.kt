package com.example.jetpackcomposetutorial.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String,
    val description: String? = null,
    val isDone: Boolean = false,
)
