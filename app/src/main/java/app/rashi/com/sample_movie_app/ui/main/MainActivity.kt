package app.rashi.com.sample_movie_app.ui.main

import android.app.ProgressDialog
import android.os.Bundle
import app.rashi.com.sample_movie_app.MovieApplication
import app.rashi.com.sample_movie_app.R
import app.rashi.com.sample_movie_app.data.api.model.TopRatedMovieResponse.ResultsItem
import app.rashi.com.sample_movie_app.di.Modules.MainActivityModule
import app.rashi.com.sample_movie_app.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), IMainActivityView {
    override fun addMoviesToList(results: List<ResultsItem?>) {

    }

    override fun showError(errorStr: String) {

    }

    override fun hideProgressDialog() {
        mProgressDialog.hide()
    }

    override fun showProgressBar() {
        mProgressDialog.show()
    }

    @Inject
    lateinit var mMainActivityPresenter: IMainActivityPresenter<IMainActivityView>

    @Inject
    lateinit var mProgressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MovieApplication).movieComponent.
                mainActivityComponent(MainActivityModule(this)).inject(this)
        mMainActivityPresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mMainActivityPresenter.onDetach()
    }
}
