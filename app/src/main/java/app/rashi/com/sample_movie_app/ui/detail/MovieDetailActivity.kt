package app.rashi.com.sample_movie_app.ui.detail

import android.app.ProgressDialog
import android.os.Bundle
import android.support.design.widget.Snackbar
import app.rashi.com.sample_movie_app.Constants
import app.rashi.com.sample_movie_app.MovieApplication
import app.rashi.com.sample_movie_app.R
import app.rashi.com.sample_movie_app.data.db.entities.MovieDetail
import app.rashi.com.sample_movie_app.di.Modules.MovieDetailModule
import app.rashi.com.sample_movie_app.ui.base.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.content_movie_detail.*
import javax.inject.Inject

class MovieDetailActivity : BaseActivity(), IMovieDetailView {

    @Inject
    lateinit var mMovieDetailPresenter: IMovieDetailPresenter<IMovieDetailView>

    @Inject
    override
    lateinit var mProgressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (application as MovieApplication).movieComponent.movieDetailComponent(MovieDetailModule(this)).inject(this)
        mMovieDetailPresenter.onAttach(this)
        mMovieDetailPresenter.setMovieDetail(intent.getIntExtra(Constants.MOVIE_ID, -1))
        initClickListeners()
    }

    private fun initClickListeners() {
        favButton.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun setMovieDetail(movieDetail: MovieDetail) {
        toolbar_layout.title = movieDetail.title
        Picasso.with(this).load("http://image.tmdb.org/t/p/w342/${movieDetail.poster_path}").into(posterImage)
        overview.text = movieDetail.overview
        release_date.text = movieDetail.release_date
        vote_average.text = movieDetail.vote_average
        if (movieDetail.favorite) {
            favButton.setImageResource(R.drawable.ic_favorite)
        } else {
            favButton.setImageResource(R.drawable.ic_favorite_border)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mMovieDetailPresenter.onDetach()
        mProgressDialog.dismiss()
    }
}