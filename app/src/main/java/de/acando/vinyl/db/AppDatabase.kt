package de.acando.vinyl.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import de.acando.vinyl.model.Article
import de.acando.vinyl.model.ShoppingCartItem

@Database(entities = arrayOf(Article::class, ShoppingCartItem::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao
    abstract fun shoppingCartDao(): ShoppingCartDao

    companion object {
        val DATABASE_NAME = "app_db"
    }
}