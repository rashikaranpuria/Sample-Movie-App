package app.rashi.com.sample_movie_app

import android.app.Application
import app.rashi.com.sample_movie_app.di.Components.AppComponent
import app.rashi.com.sample_movie_app.di.Components.DaggerAppComponent
import app.rashi.com.sample_movie_app.di.Modules.AppModule
import com.facebook.stetho.Stetho

open class MovieApplication : Application() {
    lateinit var movieComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        movieComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        Stetho.initializeWithDefaults(this)
    }
}