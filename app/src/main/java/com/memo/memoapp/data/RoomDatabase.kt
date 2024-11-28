package com.memo.memoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.memo.memoapp.data.dao.CartDao
import com.memo.memoapp.data.dao.CartListDao
import com.memo.memoapp.data.dao.MemoCategoryDao
import com.memo.memoapp.data.dao.MemoDao
import com.memo.memoapp.data.dao.ToDoListDao
import com.memo.memoapp.data.entity.Cart
import com.memo.memoapp.data.entity.CartList
import com.memo.memoapp.data.entity.Memo
import com.memo.memoapp.data.entity.MemoCategory
import com.memo.memoapp.data.entity.ToDoList
import kotlin.concurrent.Volatile

@Database(
    entities = [
        Memo::class,
        MemoCategory::class,
        Cart::class,
        CartList::class,
        ToDoList::class
    ],
    version = 1,
    exportSchema = false //스키마를 파일로 내보내지 않도록 설정
)
abstract class AppDatabase : RoomDatabase() {

    // DAO를 정의
    abstract fun memoDao(): MemoDao
    abstract fun memoCategoryDao(): MemoCategoryDao
    abstract fun cartDao(): CartDao
    abstract fun cartListDao(): CartListDao
    abstract fun toDoListDao(): ToDoListDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: android.content.Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = androidx.room.Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database" // 데이터베이스 이름
                ).fallbackToDestructiveMigration() // 스키마 변경 시 기존 데이터를 제거
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}