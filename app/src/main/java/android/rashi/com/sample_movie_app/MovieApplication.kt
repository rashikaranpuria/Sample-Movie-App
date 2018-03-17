package android.rashi.com.sample_movie_app

import android.app.Application
import android.rashi.com.sample_movie_app.di.Components.AppComponent
import android.rashi.com.sample_movie_app.di.Components.DaggerAppComponent
import android.rashi.com.sample_movie_app.di.Modules.AppModule

class MovieApplication : Application() {
    lateinit var movieComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        movieComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}