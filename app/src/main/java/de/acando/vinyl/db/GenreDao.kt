package de.acando.vinyl.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import de.acando.vinyl.model.Genre

@Dao
interface GenreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(genre: Genre)

    @Query("SELECT * FROM genre_entries")
    fun loadAll(): LiveData<List<Genre>>

    @Query("DELETE FROM genre_entries")
    fun deleteAll()
}