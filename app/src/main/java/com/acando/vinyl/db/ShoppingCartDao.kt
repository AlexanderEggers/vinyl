package com.acando.vinyl.db

import android.arch.persistence.room.Dao
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.acando.vinyl.model.ShoppingCart

@Dao
interface ShoppingCartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(shoppingCart: ShoppingCart)

    @Query("SELECT * FROM shopping_cart")
    fun loadAll(): LiveData<ShoppingCart>
}