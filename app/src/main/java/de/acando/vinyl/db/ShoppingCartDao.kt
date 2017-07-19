package de.acando.vinyl.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import de.acando.vinyl.model.ShoppingCartItem

@Dao
interface ShoppingCartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(shoppingCartItem: ShoppingCartItem)

    @Query("SELECT * FROM shopping_cart")
    fun loadAll(): LiveData<List<ShoppingCartItem>>

    @Query("DELETE FROM shopping_cart")
    fun deleteAll()

    @Delete
    fun delete(shoppingCartItem: ShoppingCartItem)
}