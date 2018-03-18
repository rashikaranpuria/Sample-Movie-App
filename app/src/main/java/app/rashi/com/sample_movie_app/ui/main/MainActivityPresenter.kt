package app.rashi.com.sample_movie_app.ui.main

import app.rashi.com.sample_movie_app.data.IDataManager
import app.rashi.com.sample_movie_app.data.api.model.TopRatedMovieResponse.ResultsItem
import app.rashi.com.sample_movie_app.data.db.entities.Movie
import app.rashi.com.sample_movie_app.ui.base.BasePresenter
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivityPresenter<V: IMainActivityView> @Inject constructor(val mDataManager: IDataManager, val mCompositeDisposable: CompositeDisposable): BasePresenter<V>(), IMainActivityPresenter<V> {
    override fun onAttach(v: V) {
        super.onAttach(v)
        view?.showProgressBar()
        mCompositeDisposable.add(mDataManager
                .fetchMoviesFromAPI()
                .map {
                    it.results?.filterNotNull()?.map {
                        it.toMovie()
                    }
                }
                .flatMapCompletable {
                    Completable.fromAction {
                        mDataManager.addMoviesToDatabase(it)
                    }
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {

                })

        mCompositeDisposable.add(mDataManager
                .fetchMoviesFromDatabase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                .subscribeBy (
                        onNext = {
                            view?.hideProgressDialog()
                            view?.addMoviesToList(it)
                        },
                        onError = {
                            view?.hideProgressDialog()
                            view?.showError(it.localizedMessage)
                        }
                ))
    }

    override fun onDetach() {
        super.onDetach()
        mCompositeDisposable.dispose()
    }
}

private fun ResultsItem.toMovie() = Movie(id, title, posterPath)
