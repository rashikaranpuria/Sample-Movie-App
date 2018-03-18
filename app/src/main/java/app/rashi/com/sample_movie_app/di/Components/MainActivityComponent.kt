package app.rashi.com.sample_movie_app.di.Components

import app.rashi.com.sample_movie_app.di.Modules.MainActivityModule
import app.rashi.com.sample_movie_app.ui.main.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}