package android.rashi.com.sample_movie_app.di.Components

import android.rashi.com.sample_movie_app.di.Modules.MainActivityModule
import android.rashi.com.sample_movie_app.ui.main.MainActivity
import dagger.Component
import dagger.Subcomponent

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}