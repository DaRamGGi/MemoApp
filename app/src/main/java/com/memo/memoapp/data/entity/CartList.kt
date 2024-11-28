package com.memo.memoapp.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "cart_list",
    foreignKeys = [
        ForeignKey(
            entity = Cart::class,
            parentColumns = ["cartId"],
            childColumns = ["cartId"],
            onDelete = ForeignKey.CASCADE // Cart 삭제 시 CartList도 삭제
        )
    ]
)
data class CartList(
    @PrimaryKey(autoGenerate = true)
    val cartListId: Int = 0,            //기본키
    val CartId: Int,                    //외래키
    val content: String,                //장바구니 항목 내용
    val quantity: Int = 1,              //항복 수량
    val isCompleted: Boolean = false    // 항목 완료 여부
)
