package android.rashi.com.sample_movie_app.data

import android.rashi.com.sample_movie_app.data.api.IApiManager
import android.rashi.com.sample_movie_app.data.api.model.TopRatedMovieResponse.MovieResponse
import io.reactivex.Single
import javax.inject.Inject

class DataManager @Inject constructor(val mApiManager: IApiManager): IDataManager {

    override fun fetchMoviesFromAPI(): Single<MovieResponse> {
        return mApiManager.fetchMoviesFromApi()
    }

}