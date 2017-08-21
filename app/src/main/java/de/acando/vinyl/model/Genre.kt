package de.acando.vinyl.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import com.google.gson.annotations.SerializedName

@Entity(tableName = "genre_entries")
class Genre {

    @PrimaryKey
    @SerializedName("genreId")
    @ColumnInfo(name = "id")
    var id: Int = 0

    @SerializedName("name")
    @ColumnInfo(name = "name")
    @NonNull
    var name: String = ""

    @SerializedName("listImage")
    @ColumnInfo(name = "list_image")
    @NonNull
    var listImage: String = ""

    @SerializedName("coverImage")
    @ColumnInfo(name = "cover_image")
    @NonNull
    var coverImage: String = ""
}