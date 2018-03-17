package android.rashi.com.sample_movie_app.di.Components

import android.rashi.com.sample_movie_app.di.Modules.AppModule
import android.rashi.com.sample_movie_app.di.Modules.MainActivityModule
import android.rashi.com.sample_movie_app.di.Modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component( modules = [AppModule::class, NetworkModule::class] )
interface AppComponent {

    fun mainActivityComponent(mainActivityModule: MainActivityModule): MainActivityComponent
}