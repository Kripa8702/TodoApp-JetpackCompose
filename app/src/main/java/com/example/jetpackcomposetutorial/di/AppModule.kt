package com.example.jetpackcomposetutorial.di

import android.content.Context
import androidx.room.Room
import com.example.jetpackcomposetutorial.data.dao.TodoDao
import com.example.jetpackcomposetutorial.data.database.TodoDatabase
import com.example.jetpackcomposetutorial.data.repository.TodoRepositoryImpl
import com.example.jetpackcomposetutorial.domain.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesTodoDatabase(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(context, TodoDatabase::class.java, "todo_db").build()

    @Provides
    fun providesTodoDao(
        todoDatabase: TodoDatabase
    ) = todoDatabase.todoDao

    @Provides
    fun providesTodoRepository(
        todoDao: TodoDao
    ): TodoRepository = TodoRepositoryImpl(
        todoDao = todoDao
    )
}