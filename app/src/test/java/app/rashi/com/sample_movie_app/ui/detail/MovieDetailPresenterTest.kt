package app.rashi.com.sample_movie_app.ui.detail

import app.rashi.com.sample_movie_app.ImmediateSchedulerRule
import app.rashi.com.sample_movie_app.data.IDataManager
import app.rashi.com.sample_movie_app.data.api.model.MovieDetailResponse.MovieDetailResponse
import app.rashi.com.sample_movie_app.data.db.entities.MovieDetail
import io.reactivex.Maybe
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

    @Mock
    lateinit var movieDetail: MovieDetail

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun fetchMovieDetailFromDatabaseCalled_WhenSetMovieDetailInvoked() {
        _when(mDataManager.fetchMovieDetailFromDatabase(ArgumentMatchers.anyInt())).thenReturn(Maybe.just(movieDetail))

        val dummyId = 45
        // when
        mMovieDetailPresenter.setMovieDetail(dummyId)
        // then
        Mockito.verify(mDataManager).fetchMovieDetailFromDatabase(dummyId)
    }

    @Test
    fun fetchMovieDetailFromDatabaseCalledButUnSuccessfulSoFetchMovieDetailFromApiCalled_WhenSetMovieDetailInvoked() {
        _when(mDataManager.fetchMovieDetailFromDatabase(ArgumentMatchers.anyInt())).thenReturn(Maybe.empty())
        _when(mDataManager.fetchMovieDetailFromAPI(ArgumentMatchers.anyInt())).thenReturn(Single.just(movieDetailResponse))

        val dummyId = 45
        // when
        mMovieDetailPresenter.setMovieDetail(dummyId)
        // then
        Mockito.verify(mDataManager).fetchMovieDetailFromDatabase(dummyId)
    }
}