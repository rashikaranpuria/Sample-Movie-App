package app.rashi.com.sample_movie_app.ui.detail

import android.util.Log
import app.rashi.com.sample_movie_app.data.IDataManager
import app.rashi.com.sample_movie_app.data.api.model.MovieDetailResponse.MovieDetailResponse
import app.rashi.com.sample_movie_app.data.db.entities.MovieDetail
import app.rashi.com.sample_movie_app.ui.base.BasePresenter
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieDetailPresenter<V: IMovieDetailView> @Inject constructor(private val mDataManager: IDataManager, private val mCompositeDisposable: CompositeDisposable) : BasePresenter<V>(), IMovieDetailPresenter<V> {

    override fun onAttach(v: V) {
        super.onAttach(v)
    }

    override fun setMovieDetail(movieId: Int) {
        view?.showProgressBar()
        // search database for this id
        mCompositeDisposable.add(mDataManager
            .fetchMovieDetailFromDatabase(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy (
                onSuccess = {
                    // Got movie detail from database
                    Log.d("movie detail", "on success")
                    updateViewWithMovieDetail(it)
                },
                onError = {
                    // some error occured
                    Log.d("movie detail", "on error")
                    view?.showError(it.localizedMessage)
                },
                onComplete = {
                    // did not find movie detail in database
                    // retrieve from API
                    Log.d("movie detail", "on complete")
                    mCompositeDisposable.add(mDataManager
                        .fetchMovieDetailFromAPI(movieId)
                        .map {
                            it.toMovieDetail()
                        }
                        .doOnSuccess {
                            Completable.fromAction {
                                Log.d("movie detail", "on complete success")
                                mDataManager.addMovieDetail(it)
                            }.subscribe()
                        }
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeBy (
                                onSuccess = {
                                    Log.d("movie detail", "on done")
                                    updateViewWithMovieDetail(it)
                                },
                                onError = {
                                    Log.d("movie detail", "on nah")
                                    view?.showError(it.localizedMessage)
                                }
                        ))
                }
            ))
        // // yes
          // show view details
        // // no
          // fetch from network

    }

    override fun onDetach() {
        super.onDetach()
        mCompositeDisposable.dispose()
    }

    private fun updateViewWithMovieDetail(movieDetail: MovieDetail) {
        view?.setMovieDetail(movieDetail)
    }

    private fun MovieDetailResponse.toMovieDetail(): MovieDetail =
            MovieDetail(id, title, posterPath.toString(), overview, releaseDate, voteAverage.toString())
}