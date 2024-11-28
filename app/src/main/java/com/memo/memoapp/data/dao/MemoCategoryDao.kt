package com.memo.memoapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.memo.memoapp.data.entity.MemoCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface MemoCategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: MemoCategory)

    @Update
    suspend fun updateCategory(category: MemoCategory)

    @Delete
    suspend fun deleteCategory(category: MemoCategory)

    @Query("SELECT * FROM memo_category ORDER BY name ASC")
    fun getAllCategories(): Flow<List<MemoCategory>>

}