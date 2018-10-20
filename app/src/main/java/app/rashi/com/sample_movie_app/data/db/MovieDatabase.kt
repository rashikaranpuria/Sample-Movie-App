package app.rashi.com.sample_movie_app.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import app.rashi.com.sample_movie_app.data.db.entities.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase : RoomDatabase () {
    abstract fun movieDao(): MovieDao

    companion object {

        @Volatile private var INSTANCE: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE
                            ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context,
                        MovieDatabase::class.java, "Movie.db")
                        .build()
    }
}