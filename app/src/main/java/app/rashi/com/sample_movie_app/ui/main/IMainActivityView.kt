package app.rashi.com.sample_movie_app.ui.main

import app.rashi.com.sample_movie_app.data.api.model.TopRatedMovieResponse.ResultsItem
import app.rashi.com.sample_movie_app.ui.base.IBaseView

interface IMainActivityView: IBaseView {
    fun showProgressBar()
    fun hideProgressDialog()
    fun showError(errorStr: String)
    fun addMoviesToList(results: List<ResultsItem?>)
}