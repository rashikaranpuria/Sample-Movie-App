package app.rashi.com.sample_movie_app.di.Modules

import android.content.Context
import app.rashi.com.sample_movie_app.R
import app.rashi.com.sample_movie_app.di.qualifiers.ActivityContext
import app.rashi.com.sample_movie_app.ui.main.IMainActivityPresenter
import app.rashi.com.sample_movie_app.ui.main.IMainActivityView
import app.rashi.com.sample_movie_app.ui.main.MainActivityPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.indeterminateProgressDialog

@Module
class MainActivityModule(val context: Context) {

    @Provides
    @ActivityContext
    fun provideContext() = context

    @Provides
    fun provideMainActivityPresenter(mainActivityPresenter: MainActivityPresenter<IMainActivityView>):IMainActivityPresenter<IMainActivityView> = mainActivityPresenter

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

    @Provides
    fun progressDialog() = context.indeterminateProgressDialog(context.getString(R.string.please_wait)).apply {
        hide()
    }
}