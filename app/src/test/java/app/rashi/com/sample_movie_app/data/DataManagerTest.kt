package app.rashi.com.sample_movie_app.data

import app.rashi.com.sample_movie_app.ImmediateSchedulerRule
import app.rashi.com.sample_movie_app.data.api.IApiManager
import app.rashi.com.sample_movie_app.data.db.IDbManager
import app.rashi.com.sample_movie_app.data.db.entities.Movie
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class DataManagerTest {

    @get:Rule
    var immediateSchedulerRule = ImmediateSchedulerRule()

    @Mock
    lateinit var mApiManager: IApiManager

    @Mock
    lateinit var mDbManager: IDbManager

    @Mock
    lateinit var movies: List<Movie>

    @InjectMocks
    lateinit var mDataManager: DataManager

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun shouldCallApiManager_WhenFetchMoviesFromApiInvoked() {
        // when fetch movie from api called
        mDataManager.fetchMoviesFromAPI()
        // then verify api manager method called
        verify(mApiManager).fetchMoviesFromApi()
    }

    @Test
    fun shouldCallDbManagerGetAllMovies_WhenFetchMoviesFromDatabaseCalled() {
        // when
        mDataManager.fetchMoviesFromDatabase()
        // then
        verify(mDbManager).getAllMovies()
    }

    @Test
    fun shouldCallAddMoviesDbManager_WhenAddMoviesToDatabaseCalled() {
        // when
        mDataManager.addMoviesToDatabase(movies)
        // then
        verify(mDbManager).addMovies(movies)
    }
}