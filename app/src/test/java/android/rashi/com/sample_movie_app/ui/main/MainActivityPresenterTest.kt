package android.rashi.com.sample_movie_app.ui.main

import android.rashi.com.sample_movie_app.data.IDataManager
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class MainActivityPresenterTest {

    @Mock
    lateinit var mDataManager: IDataManager

    @Mock
    lateinit var mMainActivity: IMainActivityView

    @InjectMocks
    lateinit var mMainActivityPresenter: MainActivityPresenter<IMainActivityView>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun onAttachFetchMoviesMethodFromDataMangerCalled() {
        mMainActivityPresenter.onAttach(mMainActivity)
        verify(mDataManager).fetchMoviesFromAPI()
    }
}