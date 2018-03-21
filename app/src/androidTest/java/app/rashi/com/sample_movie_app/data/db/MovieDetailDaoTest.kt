package app.rashi.com.sample_movie_app.data.db

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MovieDetailDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: MovieDatabase
    @Before
    fun setUp() {
        // using an in-memory database because the information stored here disappears after test
        database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                MovieDatabase::class.java)
                // allowing main thread queries, just for testing
                .allowMainThreadQueries()
                .build()
    }

    @Test
    fun movieDetailResponseTest() {
        //given
        database.movieDetailDao().getMovieDetailById(1).test()
                .assertValueCount(0)
        database.movieDetailDao().getMovieDetailById(1).test()
                .assertComplete()
    }
}