package app.rashi.com.sample_movie_app.di.Components

import app.rashi.com.sample_movie_app.di.Modules.MovieDetailModule
import app.rashi.com.sample_movie_app.ui.detail.MovieDetailActivity
import dagger.Subcomponent

@Subcomponent(modules = [MovieDetailModule::class])
interface MovieDetailComponent {
    fun inject(movieDetailActivity: MovieDetailActivity)
}