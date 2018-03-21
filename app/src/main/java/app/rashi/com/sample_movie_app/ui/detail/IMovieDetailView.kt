package app.rashi.com.sample_movie_app.ui.detail

import app.rashi.com.sample_movie_app.data.db.entities.MovieDetail
import app.rashi.com.sample_movie_app.ui.base.IBaseView

interface IMovieDetailView : IBaseView {
    fun setMovieDetail(movieDetail: MovieDetail)
    fun updateFavoriteButtonResource(isFavorite: Boolean)
}