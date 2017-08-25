package de.acando.vinyl.repository

import android.arch.lifecycle.LiveData
import de.acando.vinyl.AppExecutor
import de.acando.vinyl.api.ArticleAPIController
import de.acando.vinyl.db.ArticleDao
import de.acando.vinyl.model.Article
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepository @Inject constructor(private val articleDao: ArticleDao,
                                            private val articleAPIController: ArticleAPIController,
                                            private val appExecutor: AppExecutor) {

    fun insert(articles : List<Article>) {
        appExecutor.diskIO().execute {
            articles.forEach {
                articleDao.insert(it)
            }
        }
    }

    fun getAll() : LiveData<List<Article>> {
        return articleDao.loadAll()
    }

    fun getAll(genreId : Int) : LiveData<List<Article>> {
        return articleDao.loadAll(genreId)
    }

    fun getAll(itemIds : List<Int>) : LiveData<List<Article>> {
        return articleDao.loadAll(itemIds)
    }

    fun deleteAll() {
        appExecutor.diskIO().execute {
            articleDao.deleteAll()
        }
    }
}