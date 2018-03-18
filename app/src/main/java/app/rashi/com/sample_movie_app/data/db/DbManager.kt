package app.rashi.com.sample_movie_app.data.db

import app.rashi.com.sample_movie_app.data.db.entities.Movie
import io.reactivex.Flowable
import javax.inject.Inject

class DbManager @Inject constructor(val mMovieDao: MovieDao): IDbManager {
    override fun addMovies(movies: List<Movie>) {
        mMovieDao.insertAll(movies)
    }

    override fun getAllMovies(): Flowable<List<Movie>> = mMovieDao.getAllMovies()
}