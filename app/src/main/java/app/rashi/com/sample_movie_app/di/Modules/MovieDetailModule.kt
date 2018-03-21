package app.rashi.com.sample_movie_app.di.Modules

import android.content.Context
import app.rashi.com.sample_movie_app.R
import app.rashi.com.sample_movie_app.di.qualifiers.ActivityContext
import app.rashi.com.sample_movie_app.ui.detail.IMovieDetailPresenter
import app.rashi.com.sample_movie_app.ui.detail.IMovieDetailView
import app.rashi.com.sample_movie_app.ui.detail.MovieDetailPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.indeterminateProgressDialog

@Module
class MovieDetailModule(val context: Context) {

    @Provides
    @ActivityContext
    fun provideContext() = context

    @Provides
    fun provideMovieDetailPresenter(movieDetailPresenter: MovieDetailPresenter<IMovieDetailView>): IMovieDetailPresenter<IMovieDetailView> = movieDetailPresenter

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

    @Provides
    fun provideProgressDialog() = context.indeterminateProgressDialog(context.getString(R.string.please_wait)).apply {
        hide()
    }
}