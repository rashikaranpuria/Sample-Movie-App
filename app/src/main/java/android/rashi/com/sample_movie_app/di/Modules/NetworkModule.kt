package android.rashi.com.sample_movie_app.di.Modules

import android.rashi.com.sample_movie_app.data.api.MoviesDbAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit() = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .build()

    @Provides
    @Singleton
    fun provideTheMovieDBApi(retrofit: Retrofit) = retrofit.create(MoviesDbAPI::class.java)
}