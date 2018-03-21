package app.rashi.com.sample_movie_app.data.db

import app.rashi.com.sample_movie_app.data.db.entities.Movie
import app.rashi.com.sample_movie_app.data.db.entities.MovieDetail
import io.reactivex.Flowable
import io.reactivex.Maybe

interface IDbManager {
    fun getAllMovies(): Flowable<List<Movie>>
    fun addMovies(movies: List<Movie>)
    fun addMovieDetail(movieDetail: MovieDetail)
    fun getMovieDetail(movieId: Int): Maybe<MovieDetail>
    fun updateMovieDetail(movieId: Int, isFavorite: Boolean)
}