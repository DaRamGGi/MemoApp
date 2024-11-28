package com.memo.memoapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memo_category")
data class MemoCategory (
    @PrimaryKey(autoGenerate = true)
    val categoryId: Int = 0,        //기본키, 자동증가
    val name: String,               //카테고리 이름
    val description: String? = null // 선택적 설명 (nullable)
)
