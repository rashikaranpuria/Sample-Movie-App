package android.rashi.com.sample_movie_app.di.Components

import android.rashi.com.sample_movie_app.di.Modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component( modules = [AppModule::class] )
interface AppComponent