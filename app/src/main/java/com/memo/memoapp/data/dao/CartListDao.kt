package com.memo.memoapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.memo.memoapp.data.entity.CartList
import kotlinx.coroutines.flow.Flow

@Dao
interface CartListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartList(cartList: CartList)

    @Update
    suspend fun updateCartList(cartList: CartList)

    @Delete
    suspend fun deleteCartList(cartList: CartList)

    @Query("SELECT * FROM cart_list WHERE cartId = :cartId ORDER BY cartListId ASC")
    fun  getCartListsByCartId(cartId: Int): Flow<List<CartList>>
}