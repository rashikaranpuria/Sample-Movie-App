package app.rashi.com.sample_movie_app.ui.main

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import app.rashi.com.sample_movie_app.MovieApplication
import app.rashi.com.sample_movie_app.R
import app.rashi.com.sample_movie_app.data.db.entities.Movie
import app.rashi.com.sample_movie_app.di.Modules.MainActivityModule
import app.rashi.com.sample_movie_app.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : BaseActivity(), IMainActivityView {

    @Inject
    lateinit var mMainActivityPresenter: IMainActivityPresenter<IMainActivityView>

    @Inject
    lateinit var mProgressDialog: ProgressDialog

    @Inject
    lateinit var mAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MovieApplication).movieComponent
                .mainActivityComponent(MainActivityModule(this)).inject(this)

        // setup Recyclerview
        movie_list.setHasFixedSize(true)
        movie_list.layoutManager = GridLayoutManager(this, 2)
        movie_list.adapter = mAdapter

        mMainActivityPresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mMainActivityPresenter.onDetach()
    }

    override fun addMoviesToList(results: List<Movie>) {
        mAdapter.movieList = results
    }

    override fun showError(errorStr: String) {
        toast(errorStr)
    }

    override fun hideProgressDialog() {
        mProgressDialog.hide()
    }

    override fun showProgressBar() {
        mProgressDialog.show()
    }
}
