package app.rashi.com.sample_movie_app.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import app.rashi.com.sample_movie_app.data.db.entities.MovieDetail
import io.reactivex.Maybe

@Dao
interface MovieDetailDao {

    @Query("SELECT * FROM moviedetail WHERE id = :id")
    fun getMovieDetailById(id: Int): Maybe<MovieDetail>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(moviesDetails: List<MovieDetail>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieDetail(movieDetail: MovieDetail)
}