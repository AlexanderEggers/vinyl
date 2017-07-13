package com.acando.vinyl.repository

import android.arch.lifecycle.LiveData
import com.acando.vinyl.AppExecutor
import com.acando.vinyl.db.ArticleDao
import com.acando.vinyl.model.Article
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepository @Inject constructor(private val articleDao: ArticleDao,
                                            private val appExecutor: AppExecutor) {

    fun insertItem(articles : List<Article>) {
        appExecutor.diskIO().execute {
            articles.forEach {
                articleDao.insert(it)
            }
        }
    }

    fun getAllShoppingCartItems() : LiveData<List<Article>> {
        return articleDao.loadAll()
    }
}