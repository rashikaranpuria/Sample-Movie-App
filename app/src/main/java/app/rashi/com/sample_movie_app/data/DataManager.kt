package app.rashi.com.sample_movie_app.data

import app.rashi.com.sample_movie_app.data.api.IApiManager
import app.rashi.com.sample_movie_app.data.api.model.MovieDetailResponse.MovieDetailResponse
import app.rashi.com.sample_movie_app.data.api.model.TopRatedMovieResponse.MovieResponse
import app.rashi.com.sample_movie_app.data.db.IDbManager
import app.rashi.com.sample_movie_app.data.db.entities.Movie
import app.rashi.com.sample_movie_app.data.db.entities.MovieDetail
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class DataManager @Inject constructor(val mApiManager: IApiManager, val mDbManager: IDbManager) : IDataManager {
    override fun fetchMovieDetailFromDatabase(movieId: Int): Maybe<MovieDetail> {
        return mDbManager.getMovieDetail(movieId)
    }

    override fun addMovieDetail(movieDetail: MovieDetail) {
        mDbManager.addMovieDetail(movieDetail)
    }

    override fun fetchMovieDetailFromAPI(movieId: Int): Single<MovieDetailResponse> {
        return mApiManager.fetchMovieDetail(movieId.toString())
    }

    override fun fetchMoviesFromDatabase(): Flowable<List<Movie>> {
        return mDbManager.getAllMovies()
    }

    override fun addMoviesToDatabase(list: List<Movie>) {
        mDbManager.addMovies(list)
    }

    override fun fetchMoviesFromAPI(): Single<MovieResponse> {
        return mApiManager.fetchMoviesFromApi()
    }
}