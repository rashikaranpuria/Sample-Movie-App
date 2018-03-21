package app.rashi.com.sample_movie_app.ui.main

import app.rashi.com.sample_movie_app.data.db.entities.Movie
import app.rashi.com.sample_movie_app.ui.base.IBaseView

interface IMainActivityView : IBaseView {
    fun addMoviesToList(results: List<Movie>)
    fun openDetailActivity(movieId: Int)
}