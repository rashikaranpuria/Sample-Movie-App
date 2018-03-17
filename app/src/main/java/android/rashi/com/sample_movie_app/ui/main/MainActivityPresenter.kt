package android.rashi.com.sample_movie_app.ui.main

import android.rashi.com.sample_movie_app.data.IDataManager
import android.rashi.com.sample_movie_app.ui.base.BasePresenter
import javax.inject.Inject

class MainActivityPresenter<V: IMainActivityView> @Inject constructor(val mDataManager: IDataManager): BasePresenter<V>(), IMainActivityPresenter<V> {
    override fun onAttach(v: V) {
        super.onAttach(v)
        mDataManager.fetchMoviesFromAPI()
    }
}