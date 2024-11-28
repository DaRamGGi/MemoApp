package com.memo.memoapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.memo.memoapp.data.entity.Memo
import kotlinx.coroutines.flow.Flow


@Dao
interface MemoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemo(memo: Memo)

    @Update
    suspend fun updateMemo(memo: Memo)

    @Delete
    suspend fun deleteMemo(memo: Memo)

    @Query("SELECT * FROM memo ORDER BY createdAt DESC")
    fun getAllMemos(): Flow<List<Memo>>

    @Query("SELECT * FROM memo WHERE memoId = :id")
    suspend fun getMemoById(id: Int): Memo?
}