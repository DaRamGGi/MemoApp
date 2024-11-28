package com.memo.memoapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class Cart(
    @PrimaryKey(autoGenerate = true)
    val cartId: Int = 0,                // 기본키
    val title: String,                  //장바구니 제목
    val startDate: Long,                //장바구니 생성일
    val endDate: Long? = null,          //장바구니 완료일 (nullable)
    val isCompleted: Boolean = false    //장바구니 완료 여부
)
