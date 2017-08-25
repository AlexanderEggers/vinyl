package de.acando.vinyl.repository

import android.arch.lifecycle.LiveData
import de.acando.vinyl.AppExecutor
import de.acando.vinyl.api.GenreAPIController
import de.acando.vinyl.db.GenreDao
import de.acando.vinyl.model.Genre
import javax.inject.Inject

class GenreRepository @Inject constructor(private val genreDao: GenreDao,
                                          private val genreAPIController: GenreAPIController,
                                          private val appExecutor: AppExecutor) {

    fun insert(articles : List<Genre>) {
        appExecutor.diskIO().execute {
            articles.forEach {
                genreDao.insert(it)
            }
        }
    }

    fun getAll() : LiveData<List<Genre>> {
        return genreDao.loadAll()
    }

    fun deleteAll() {
        appExecutor.diskIO().execute {
            genreDao.deleteAll()
        }
    }
}