package app.rashi.com.sample_movie_app.data.db

import app.rashi.com.sample_movie_app.data.db.entities.Movie
import io.reactivex.Flowable

interface IDbManager {
    fun getAllMovies(): Flowable<List<Movie>>
    fun addMovies(movies: List<Movie>)
}