package app.rashi.com.sample_movie_app.di.Modules

import app.rashi.com.sample_movie_app.data.api.MoviesDbAPI
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton

    fun provideRetrofit() = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideTheMovieDBApi(retrofit: Retrofit) = retrofit.create(MoviesDbAPI::class.java)
}