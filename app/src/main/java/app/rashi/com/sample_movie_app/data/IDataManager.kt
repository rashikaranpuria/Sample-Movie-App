package app.rashi.com.sample_movie_app.data

import app.rashi.com.sample_movie_app.data.api.model.TopRatedMovieResponse.MovieResponse
import io.reactivex.Single

interface IDataManager {
    fun fetchMoviesFromAPI(): Single<MovieResponse>
}