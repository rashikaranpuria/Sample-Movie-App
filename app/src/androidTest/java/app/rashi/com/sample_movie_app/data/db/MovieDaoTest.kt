package app.rashi.com.sample_movie_app.data.db

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import app.rashi.com.sample_movie_app.data.db.entities.Movie
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {
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
    fun shouldInsertListOfMovies() {
        //given
        val movieList = arrayListOf(Movie(1, "t", ""), Movie(3, "tdf", ""))
        //when
        database.movieDao().insertAll(movieList)
        //then
        database.movieDao().getMovieById(1).test().assertValueCount(1)
        database.movieDao().getMovieById(3).test().assertValueCount(1)
    }

    @After
    fun clear() {
        database.close()
    }

    @Test
    fun shouldInsrtMovie() {
        //when
        database.movieDao().insertMovie(MOVIE_ITEM)
        //then
        database.movieDao().getMovieById(MOVIE_ITEM.id).test().assertValue {
            it.poster_path == MOVIE_ITEM.poster_path && it.title == MOVIE_ITEM.title
        }
    }

    companion object {
        val MOVIE_ITEM = Movie(1, "shawshank", "/der.jpf")
    }
}