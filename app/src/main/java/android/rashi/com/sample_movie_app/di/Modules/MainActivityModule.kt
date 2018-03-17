package android.rashi.com.sample_movie_app.di.Modules

import android.rashi.com.sample_movie_app.ui.main.IMainActivityPresenter
import android.rashi.com.sample_movie_app.ui.main.IMainActivityView
import android.rashi.com.sample_movie_app.ui.main.MainActivityPresenter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideMainActivityPresenter(mainActivityPresenter: MainActivityPresenter<IMainActivityView>):IMainActivityPresenter<IMainActivityView> = mainActivityPresenter
}