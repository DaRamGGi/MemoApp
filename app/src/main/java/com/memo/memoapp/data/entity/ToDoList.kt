package com.memo.memoapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "to_do_list")
data class ToDoList(
    @PrimaryKey(autoGenerate = true)
    val toDoId: Int = 0,                //기본키
    val title: String,                  //할 일 제목
    val description: String?,           //할 일 내용
    val createdAt:Long,                 //생성 날짜
    val isCompleted: Boolean = false,   //완료 ㅇ여부
    val priority: Int = 0               //우선순위 (낮은 숫자가 높은 우선 순위)
)
