package de.acando.vinyl.repository

import android.arch.lifecycle.LiveData
import de.acando.vinyl.AppExecutor
import de.acando.vinyl.db.ShoppingCartDao
import de.acando.vinyl.model.ShoppingCartItem
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