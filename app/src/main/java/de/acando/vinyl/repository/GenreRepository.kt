package de.acando.vinyl.repository

import de.acando.vinyl.AppExecutor
import de.acando.vinyl.db.GenreDao
import javax.inject.Inject

class GenreRepository @Inject constructor(private val genreDao: GenreDao,
                                          private val appExecutor: AppExecutor) {


}