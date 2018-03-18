package app.rashi.com.sample_movie_app.ui.main

import app.rashi.com.sample_movie_app.ImmediateSchedulerRule
import app.rashi.com.sample_movie_app.data.IDataManager
import app.rashi.com.sample_movie_app.data.api.model.TopRatedMovieResponse.MovieResponse
import app.rashi.com.sample_movie_app.data.api.model.TopRatedMovieResponse.ResultsItem
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import java.io.IOException
import org.mockito.Mockito.`when` as _when

class MainActivityPresenterTest {

    @get:Rule
    var immediateSchedulerRule = ImmediateSchedulerRule()

    @Mock
    lateinit var mDataManager: IDataManager

    @Mock
    lateinit var mMainActivity: IMainActivityView

    @Mock
    lateinit var mCompositeDisposable: CompositeDisposable

    @InjectMocks
    lateinit var mMainActivityPresenter: MainActivityPresenter<IMainActivityView>

    @Mock
    lateinit var movieResponse: MovieResponse

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        _when(mDataManager.fetchMoviesFromAPI()).thenReturn(Single.just(movieResponse))

    }

    @Test
    fun onAttachFetchMoviesMethodFromDataMangerCalled() {
        // when
        mMainActivityPresenter.onAttach(mMainActivity)
        // then
        verify(mDataManager).fetchMoviesFromAPI()
    }

    @Test
    fun showProgressBar_WhileFetchingData() {
        // when
        mMainActivityPresenter.onAttach(mMainActivity)
        // then
        verify(mMainActivity).showProgressBar()
    }

    @Test
    fun shouldHideProgressDialog_WhenNetworkRequestCompleteSuccessfully() {

        // when
        mMainActivityPresenter.onAttach(mMainActivity)
        // then
        verify(mMainActivity).hideProgressDialog()

    }

    @Test
    fun shouldCallShowList_WhenNetworkRequestCompleteSuccessfully() {
        // when
        mMainActivityPresenter.onAttach(mMainActivity)
        // then
        verify(mMainActivity).addMoviesToList(movieResponse.results as List<ResultsItem>)

    }

    @Test
    fun shouldHideProgressDialog_WhenNetworkRequestFails() {
        // given
        val exception = IOException("")
        _when(mDataManager.fetchMoviesFromAPI()).thenReturn(Single.error(exception))
        // when
        mMainActivityPresenter.onAttach(mMainActivity)
        // then
        verify(mMainActivity).hideProgressDialog()
        verify(mMainActivity).showError(exception.localizedMessage)

    }
}