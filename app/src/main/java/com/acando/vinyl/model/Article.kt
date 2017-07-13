package com.acando.vinyl.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "articles")
class Article {

    @PrimaryKey
    @SerializedName("articleId")
    var id: Int = 0

    @SerializedName("album")
    var album: String? = null

    @ColumnInfo(name = "vote_average")
    @SerializedName("voteAverage")
    var voteAverage: Float = 0.toFloat()

    @SerializedName("price")
    var price: Float = 0.toFloat()

    @SerializedName("release")
    var release: Int = 0

    @ColumnInfo(name = "band")
    @SerializedName("band")
    var band: String? = null

    @SerializedName("coverImage")
    @ColumnInfo(name = "cover_image")
    var coverImage: Int = 0
}