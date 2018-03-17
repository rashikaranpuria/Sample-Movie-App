package android.rashi.com.sample_movie_app.data

import android.rashi.com.sample_movie_app.data.api.model.TopRatedMovieResponse.MovieResponse
import io.reactivex.Single

interface IDataManager {
    fun fetchMoviesFromAPI(): Single<MovieResponse>
}