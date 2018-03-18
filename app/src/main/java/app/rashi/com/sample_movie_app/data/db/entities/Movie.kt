package app.rashi.com.sample_movie_app.data.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey
    @ColumnInfo
    val id: Int,

    @ColumnInfo
    val title: String,

    @ColumnInfo
    val poster_path: String
)