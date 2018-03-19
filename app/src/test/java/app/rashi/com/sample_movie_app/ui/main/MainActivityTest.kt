package app.rashi.com.sample_movie_app.ui.main

import android.app.ProgressDialog
import app.rashi.com.sample_movie_app.BuildConfig
import app.rashi.com.sample_movie_app.FakeApplication
import app.rashi.com.sample_movie_app.data.db.entities.Movie
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowToast

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, application = FakeApplication::class)
class MainActivityTest {

    @Mock
    lateinit var mProgressDialog: ProgressDialog

//    @Mock
//    lateinit var mMainActivityPresenter: IMainActivityPresenter<IMainActivityView>

    lateinit var movieAdapter: MovieAdapter

    @Mock
    lateinit var movies: List<Movie>

    lateinit var mMainActivity: MainActivity

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mMainActivity = Robolectric.buildActivity(MainActivity::class.java).create().start().resume().get()
//        movieAdapter = MovieAdapter(mMainActivity)
//        mMainActivity.mAdapter = movieAdapter
    }

    @Test
    fun progresDialogShown_WhenShowProgressDialogCalled() {
        // given
        mMainActivity.mProgressDialog = mProgressDialog
        // when
        mMainActivity.showProgressBar()
        // verify
        verify(mProgressDialog).show()
    }

    @Test
    fun progresDialogHidden_WhenHideProgressDialogCalled() {
        // given
        mMainActivity.mProgressDialog = mProgressDialog
        // when
        mMainActivity.hideProgressDialog()
        // verify
        verify(mProgressDialog).hide()
    }

    @Test
    fun toastShown_WhenShowErrorCalled() {
        // given
        val errorStr = "error"
        // when
        mMainActivity.showError(errorStr)
        // verify
        assertEquals(ShadowToast.getTextOfLatestToast(), errorStr)
    }

    @Test
    fun onClickMovieItemCalled_WhenRecyclerViewItemClicked() {

        val m1 = Movie(1, "45", "5454")
        val list = listOf(m1, m1.copy(id = 2), m1.copy(id = 3))

        // given
        val recyclerView = mMainActivity.movie_list
        recyclerView.measure(0, 0)
        recyclerView.layout(0, 0, 100, 1000)
//        recyclerView.adapter = movieAdapter
        mMainActivity.mAdapter.movieList = list
        // when
        recyclerView.findViewHolderForAdapterPosition(0).itemView.performClick()
        // then
        verify(mMainActivity.mMainActivityPresenter).recyclerViewItemClicked()
    }
}