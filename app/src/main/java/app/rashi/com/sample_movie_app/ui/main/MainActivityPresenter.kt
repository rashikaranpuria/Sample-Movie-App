package app.rashi.com.sample_movie_app.ui.main

import app.rashi.com.sample_movie_app.data.IDataManager
import app.rashi.com.sample_movie_app.ui.base.BasePresenter
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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy (
                        onSuccess = {
                            view?.hideProgressDialog()
                            it.results?.let { view?.addMoviesToList(it.filterNotNull()) }
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