package android.rashi.com.sample_movie_app.data.api

import android.rashi.com.sample_movie_app.data.api.model.TopRatedMovieResponse.MovieResponse
import io.reactivex.Single

interface IApiManager {
    fun fetchMoviesFromApi(): Single<MovieResponse>
}