package app.rashi.com.sample_movie_app.ui.detail

import app.rashi.com.sample_movie_app.ImmediateSchedulerRule
import app.rashi.com.sample_movie_app.data.IDataManager
import app.rashi.com.sample_movie_app.data.api.model.MovieDetailResponse.MovieDetailResponse
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as _when

class MovieDetailPresenterTest {

    @get:Rule
    var immediateSchedulerRule = ImmediateSchedulerRule()

    @Mock
    lateinit var mDataManager: IDataManager

    @Mock
    lateinit var mCompositeDisposable: CompositeDisposable

    @InjectMocks
    lateinit var mMovieDetailPresenter: MovieDetailPresenter<IMovieDetailView>

    @Mock
    lateinit var movieDetailResponse: MovieDetailResponse

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        _when(mDataManager.fetchMovieDetailFromAPI(ArgumentMatchers.anyInt())).thenReturn(Single.just(movieDetailResponse))
    }

    @Test
    fun fetchMovieDetailFromApiCalled_WhenSetMovieDetailInvoked() {
        val dummyId = 45
        // when
        mMovieDetailPresenter.setMovieDetail(dummyId)
        // then
        Mockito.verify(mDataManager).fetchMovieDetailFromAPI(dummyId)
    }

    @Test
    fun fetchMovieDetailFromDatabaseCalled_WhenSetMovieDetailInvoked() {
        val dummyId = 45
        // when
        mMovieDetailPresenter.setMovieDetail(dummyId)
        // then
        Mockito.verify(mDataManager).fetchMovieDetailFromDatabase(dummyId)
    }
}