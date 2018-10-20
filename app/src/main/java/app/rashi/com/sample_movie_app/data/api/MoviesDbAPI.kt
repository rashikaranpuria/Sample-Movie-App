package app.rashi.com.sample_movie_app.data.api

import app.rashi.com.sample_movie_app.BuildConfig
import app.rashi.com.sample_movie_app.data.api.model.TopRatedMovieResponse.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET

interface MoviesDbAPI {

    @GET("top_rated?api_key=${BuildConfig.API_KEY}&language=en-US")
    fun getTopRatedMovies(): Single<MovieResponse>
}