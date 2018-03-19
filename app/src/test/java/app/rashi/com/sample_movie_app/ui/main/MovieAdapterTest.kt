package app.rashi.com.sample_movie_app.ui.main

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import app.rashi.com.sample_movie_app.BuildConfig
import app.rashi.com.sample_movie_app.FakeApplication
import app.rashi.com.sample_movie_app.data.db.entities.Movie
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, application = FakeApplication::class)
class MovieAdapterTest {

    lateinit var context: Context

    @Before
    fun setUp() {
        context = RuntimeEnvironment.application
    }

    @Test
    fun testAdapter() {
        var movies = listOf(
                Movie(1, "title1", "shd.jpg"),
                Movie(2, "title2", "shd.jpg"),
                Movie(3, "title3", "shd.jpg")
        )

        val movieAdapter = MovieAdapter(context)
        movieAdapter.movieList = movies

        val rv = RecyclerView(context)
        rv.layoutManager = GridLayoutManager(context, 2)
        val viewHolder = movieAdapter.onCreateViewHolder(rv, 0)
        movieAdapter.bindViewHolder(viewHolder, 0)

        assertEquals("title1", viewHolder.titleView.text.toString())

        assertEquals(3, movieAdapter.itemCount)
    }
}