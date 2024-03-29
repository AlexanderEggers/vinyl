package de.acando.vinyl.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import de.acando.vinyl.model.Article
import de.acando.vinyl.model.Genre
import de.acando.vinyl.model.ShoppingCartItem

@Database(entities = arrayOf(Article::class, Genre::class, ShoppingCartItem::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao
    abstract fun shoppingCartDao(): ShoppingCartDao
    abstract fun genreDao(): GenreDao

    companion object {
        val DATABASE_NAME = "app_db"
    }
}