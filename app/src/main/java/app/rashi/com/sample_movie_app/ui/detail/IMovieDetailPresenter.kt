package app.rashi.com.sample_movie_app.ui.detail

import app.rashi.com.sample_movie_app.ui.base.IBasePresenter

interface IMovieDetailPresenter<V: IMovieDetailView> : IBasePresenter<V> {
    fun setMovieDetail(movieId: Int)
}