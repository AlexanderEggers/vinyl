package com.acando.vinyl.repository

import android.arch.lifecycle.LiveData
import com.acando.vinyl.AppExecutor
import com.acando.vinyl.db.ShoppingCartDao
import com.acando.vinyl.model.ShoppingCartItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShoppingCartRepository @Inject constructor(private val shoppingCartDao: ShoppingCartDao,
                                                 private val appExecutor: AppExecutor) {

    fun insertItem(shoppingCartItem: ShoppingCartItem) {
        appExecutor.diskIO().execute {
            shoppingCartDao.insert(shoppingCartItem)
        }
    }

    fun getAllShoppingCartItems() : LiveData<List<ShoppingCartItem>> {
        return shoppingCartDao.loadAll()
    }

    fun deleteAll() {
        appExecutor.diskIO().execute {
            shoppingCartDao.deleteAll()
        }
    }

    fun deleteItem(shoppingCartItem: ShoppingCartItem) {
        appExecutor.diskIO().execute {
            shoppingCartDao.delete(shoppingCartItem)
        }
    }

}