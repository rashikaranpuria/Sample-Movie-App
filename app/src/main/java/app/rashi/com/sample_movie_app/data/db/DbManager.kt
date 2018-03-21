package app.rashi.com.sample_movie_app.data.db

import app.rashi.com.sample_movie_app.data.db.entities.Movie
import app.rashi.com.sample_movie_app.data.db.entities.MovieDetail
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Inject

class DbManager @Inject constructor(val mMovieDao: MovieDao, val mMovieDetailDao: MovieDetailDao) : IDbManager {
    override fun getMovieDetail(movieId: Int): Maybe<MovieDetail> {
        return mMovieDetailDao.getMovieDetailById(movieId)
    }

    override fun addMovieDetail(movieDetail: MovieDetail) {
        mMovieDetailDao.insertMovieDetail(movieDetail)
    }

    override fun addMovies(movies: List<Movie>) {
        mMovieDao.insertAll(movies)
    }

    override fun getAllMovies(): Flowable<List<Movie>> = mMovieDao.getAllMovies()
}