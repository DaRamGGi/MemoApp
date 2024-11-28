package com.memo.memoapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "memo",
    foreignKeys = [
        ForeignKey(
            entity = MemoCategory::class,
            parentColumns = ["categoryId"],
            childColumns = ["categoryId"],
            onDelete = androidx.room.ForeignKey.SET_NULL // 카테고리 삭제 시 categoryId를 NULL로 설정
        )
    ]
)
data class Memo (
    @PrimaryKey(autoGenerate = true)
    val memoId: Int = 0,            //기본키, 자동 증가
    val title: String,              //메모 제목
    val content: String,            //메모 내용
    val createdAt: Long,            //작성 날짜 (타임 스탬프)
    val isFavorite: Boolean = false,//즐겨찾기 여부
    val categoryId: Int? = null     // Foreign Key (nullable)
)