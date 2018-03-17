package android.rashi.com.sample_movie_app.ui.main

import android.os.Bundle
import android.rashi.com.sample_movie_app.MovieApplication
import android.rashi.com.sample_movie_app.R
import android.rashi.com.sample_movie_app.di.Modules.MainActivityModule
import android.rashi.com.sample_movie_app.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), IMainActivityView {

    @Inject
    lateinit var mMainActivityPresenter: IMainActivityPresenter<IMainActivityView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MovieApplication).movieComponent.mainActivityComponent(MainActivityModule()).inject(this)
        mMainActivityPresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mMainActivityPresenter.onDetach()
    }
}
