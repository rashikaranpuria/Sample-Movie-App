package app.rashi.com.sample_movie_app.ui.main

import android.app.ProgressDialog
import app.rashi.com.sample_movie_app.BuildConfig
import app.rashi.com.sample_movie_app.FakeApplication
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, application = FakeApplication::class)
class MainActivityTest {

    @Mock
    lateinit var mProgressDialog: ProgressDialog

    lateinit var mMainActivity: MainActivity

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mMainActivity = Robolectric.buildActivity(MainActivity::class.java).create().get()
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
}