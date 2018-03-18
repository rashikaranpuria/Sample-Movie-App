package app.rashi.com.sample_movie_app.di.Modules

import android.app.Application
import app.rashi.com.sample_movie_app.data.DataManager
import app.rashi.com.sample_movie_app.data.IDataManager
import app.rashi.com.sample_movie_app.data.api.ApiManager
import app.rashi.com.sample_movie_app.data.api.IApiManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: Application) {

    @Provides
    @Singleton
    fun provideDataManager(mDataManager: DataManager): IDataManager = mDataManager

    @Provides
    @Singleton
    fun provideApiManager(mApiManager: ApiManager) = mApiManager as IApiManager
}