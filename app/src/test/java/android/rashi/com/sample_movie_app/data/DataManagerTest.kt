package android.rashi.com.sample_movie_app.data

import android.rashi.com.sample_movie_app.data.api.IApiManager
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class DataManagerTest {

    @Mock
    lateinit var mApiManager: IApiManager

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
}