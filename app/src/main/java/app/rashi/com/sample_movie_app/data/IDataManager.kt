package app.rashi.com.sample_movie_app.data

import app.rashi.com.sample_movie_app.data.api.model.TopRatedMovieResponse.MovieResponse
import app.rashi.com.sample_movie_app.data.db.entities.Movie
import io.reactivex.Flowable
import io.reactivex.Single

interface IDataManager {
    fun fetchMoviesFromAPI(): Single<MovieResponse>
    fun addMoviesToDatabase(list: List<Movie>)
    fun fetchMoviesFromDatabase(): Flowable<List<Movie>>
}