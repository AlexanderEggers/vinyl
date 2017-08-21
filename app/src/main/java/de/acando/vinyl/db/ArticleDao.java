package de.acando.vinyl.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import de.acando.vinyl.model.Article;

@Dao
public interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Article article);

    @Query("SELECT * FROM article_entries")
    LiveData<List<Article>> loadAll();

    @Query("SELECT * FROM article_entries WHERE genre_id = :genreId")
    LiveData<List<Article>> loadAll(int genreId);

    @Query("SELECT * FROM article_entries WHERE id IN (:itemIds)")
    LiveData<List<Article>> loadAll(List<Integer> itemIds);
}
