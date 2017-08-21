package de.acando.vinyl.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import com.google.gson.annotations.SerializedName

@Entity(tableName = "article_entries")
class Article {

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("articleId")
    var id: Int = 0

    @ColumnInfo(name = "album")
    @SerializedName("album")
    @NonNull
    var album: String = ""

    @ColumnInfo(name = "genre_id")
    @SerializedName("genreId")
    @NonNull
    var genreId: Int = 0

    @ColumnInfo(name = "vote_average")
    @SerializedName("voteAverage")
    @NonNull
    var voteAverage: Float = 0f

    @ColumnInfo(name = "price")
    @SerializedName("price")
    @NonNull
    var price: Float = 0f

    @ColumnInfo(name = "release")
    @SerializedName("release")
    @NonNull
    var release: Int = 0

    @SerializedName("band")
    @ColumnInfo(name = "band")
    @NonNull
    var band: String = ""

    @ColumnInfo(name = "cover_image")
    @SerializedName("coverImage")
    @NonNull
    var coverImage: String = ""
}