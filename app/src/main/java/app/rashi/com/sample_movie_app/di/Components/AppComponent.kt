package app.rashi.com.sample_movie_app.di.Components

import app.rashi.com.sample_movie_app.di.Modules.AppModule
import app.rashi.com.sample_movie_app.di.Modules.MainActivityModule
import app.rashi.com.sample_movie_app.di.Modules.MovieDetailModule
import app.rashi.com.sample_movie_app.di.Modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component( modules = [AppModule::class, NetworkModule::class] )
interface AppComponent {

    fun mainActivityComponent(mainActivityModule: MainActivityModule): MainActivityComponent

    fun movieDetailComponent(movieDetailModule: MovieDetailModule): MovieDetailComponent
}