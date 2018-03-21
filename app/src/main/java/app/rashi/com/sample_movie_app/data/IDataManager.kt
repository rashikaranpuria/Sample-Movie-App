package app.rashi.com.sample_movie_app.data

import app.rashi.com.sample_movie_app.data.api.model.MovieDetailResponse.MovieDetailResponse
import app.rashi.com.sample_movie_app.data.api.model.TopRatedMovieResponse.MovieResponse
import app.rashi.com.sample_movie_app.data.db.entities.Movie
import app.rashi.com.sample_movie_app.data.db.entities.MovieDetail
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single

interface IDataManager {
    // movie ops
    fun fetchMoviesFromAPI(): Single<MovieResponse>
    fun addMoviesToDatabase(list: List<Movie>)
    fun fetchMoviesFromDatabase(): Flowable<List<Movie>>
    //movie detail ops
    fun fetchMovieDetailFromAPI(movieId: Int): Single<MovieDetailResponse>
    fun addMovieDetail(movieDetail: MovieDetail)
    fun fetchMovieDetailFromDatabase(movieId: Int): Maybe<MovieDetail>
    fun updateMovieDetail(movieId: Int, isFavorite: Boolean)
}