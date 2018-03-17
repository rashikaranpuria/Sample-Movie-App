package android.rashi.com.sample_movie_app.data.api

import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class ApiManagerTest {

    @Mock
    lateinit var mMoviesDbAPI: MoviesDbAPI

    @InjectMocks
    lateinit var mApiManager: ApiManager

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun shouldInvokeMovieDbApi_WhenFetchMovieApiCalled() {
        // when
        mApiManager.fetchMoviesFromApi()
        // then
        verify(mMoviesDbAPI).getTopRatedMovies()
    }
}