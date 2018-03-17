package android.rashi.com.sample_movie_app.ui.main

import android.app.ProgressDialog
import android.os.Bundle
import android.rashi.com.sample_movie_app.MovieApplication
import android.rashi.com.sample_movie_app.R
import android.rashi.com.sample_movie_app.di.Modules.MainActivityModule
import android.rashi.com.sample_movie_app.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), IMainActivityView {
    override fun showError(errorStr: String) {
    }

    override fun hideProgressDialog() {
    }

    override fun showProgressBar() {
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
