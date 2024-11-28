package com.memo.memoapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.memo.memoapp.data.entity.ToDoList
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToDo(toDo: ToDoList)

    @Update
    suspend fun updateToDo(toDo: ToDoList)

    @Delete
    suspend fun deleteToDo(toDo: ToDoList)

    @Query("SELECT * FROM to_do_list ORDER BY priority ASC, createdAt DESC")
    fun getAllToDos(): Flow<List<ToDoList>>

    @Query("SELECT * FROM to_do_list WHERE isCompleted = :isCompleted ORDER BY priority ASC")
    fun getToDosByCompletionStatus(isCompleted: Boolean): Flow<List<ToDoList>>
}