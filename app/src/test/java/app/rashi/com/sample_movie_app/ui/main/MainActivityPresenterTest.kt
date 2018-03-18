package app.rashi.com.sample_movie_app.ui.main

import app.rashi.com.sample_movie_app.ImmediateSchedulerRule
import app.rashi.com.sample_movie_app.data.IDataManager
import app.rashi.com.sample_movie_app.data.api.model.TopRatedMovieResponse.MovieResponse
import app.rashi.com.sample_movie_app.data.db.entities.Movie
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
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

    @Mock
    lateinit var movies: List<Movie>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        _when(mDataManager.fetchMoviesFromAPI()).thenReturn(Single.just(movieResponse))
        _when(mDataManager.fetchMoviesFromDatabase()).thenReturn(Flowable.just(movies))
    }

    @Test
    fun fetchMoviesMethodFromDataMangerCalled_WhenPresenterAttached() {
        // when
        mMainActivityPresenter.onAttach(mMainActivity)
        // then
        verify(mDataManager).fetchMoviesFromAPI()
    }

    @Test
    fun fetchMoviesFromDatabaseCalled_WhenPresenterAttached() {
        // when
        mMainActivityPresenter.onAttach(mMainActivity)
        // then
        verify(mDataManager).fetchMoviesFromDatabase()
    }

    @Test
    fun showProgressBar_WhileFetchingDataFromDatabase() {
        // when
        mMainActivityPresenter.onAttach(mMainActivity)
        // then
        verify(mMainActivity).showProgressBar()
    }

    @Test
    fun shouldHideProgressDialog_WhenDatabaseReturnedMoviesSuccessfully() {

        // when
        mMainActivityPresenter.onAttach(mMainActivity)
        // then
        verify(mMainActivity).hideProgressDialog()
    }

    @Test
    fun shouldSaveDataInDatabase_WhenNetworkRequestCompleteSuccessfully() {

        // when
        mMainActivityPresenter.onAttach(mMainActivity)
        // then
        verify(mDataManager).addMoviesToDatabase(ArgumentMatchers.anyListOf(Movie::class.java))
    }

    @Test
    fun shouldCallShowList_WhenMoviesFetchedFromDatabase() {
        // when
        mMainActivityPresenter.onAttach(mMainActivity)
        // then
        verify(mMainActivity).addMoviesToList(movies)
    }

    @Test
    fun shouldHideProgressDialog_WhenDatabaseFetchFails() {
        // given
        val exception = IOException("")
        _when(mDataManager.fetchMoviesFromDatabase()).thenReturn(Flowable.error(exception))
        // when
        mMainActivityPresenter.onAttach(mMainActivity)
        // then
        verify(mMainActivity).hideProgressDialog()
        verify(mMainActivity).showError(exception.localizedMessage)
    }
}