package com.acando.vinyl.db

import android.arch.persistence.room.Dao
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.acando.vinyl.model.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(article : Article)

    @Query("SELECT * FROM articles")
    fun loadAll(): LiveData<List<Article>>
}