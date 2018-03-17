package android.rashi.com.sample_movie_app.ui.main

import android.app.ProgressDialog
import android.rashi.com.sample_movie_app.BuildConfig
import android.rashi.com.sample_movie_app.FakeApplication
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
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
}