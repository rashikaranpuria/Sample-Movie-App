package app.rashi.com.sample_movie_app.data.db

import app.rashi.com.sample_movie_app.data.db.entities.Movie
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class DbManagerTest {

    @Mock
    lateinit var mMovieDao: MovieDao

    @Mock
    lateinit var movies: List<Movie>

    @InjectMocks
    lateinit var mDbManager: DbManager

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun insertAllMethodOfDaoCalled_WhenAddMoviesInvoked() {
        // when
        mDbManager.addMovies(movies)
        // then
        verify(mMovieDao).insertAll(movies)
    }

    @Test
    fun getAllMovies() {
        // when
        mDbManager.getAllMovies()
        // then
        verify(mMovieDao).getAllMovies()
    }
}