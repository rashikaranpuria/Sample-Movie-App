package app.rashi.com.sample_movie_app.data.api

import javax.inject.Inject

class ApiManager @Inject constructor(val moviesDbAPI: MoviesDbAPI) : IApiManager {
    override fun fetchMoviesFromApi() = moviesDbAPI.getTopRatedMovies()
}