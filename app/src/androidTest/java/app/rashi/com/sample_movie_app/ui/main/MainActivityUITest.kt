package app.rashi.com.sample_movie_app.ui.main

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import app.rashi.com.sample_movie_app.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityUITest {

    @get:Rule
    val mActivityRule: IntentsTestRule<MainActivity> = IntentsTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun ensureAllElementsDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.movie_list)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testSomeItemInRecyclerView() {
        val mv = mActivityRule.activity.mAdapter.movieList
        val i = mv.count()/2
        onView(withId(R.id.movie_list))
                .perform(RecyclerViewActions.scrollToPosition<MovieAdapter.MovieViewHolder>(i))
        onView(withText(mv.get(i).title)).check(matches(isDisplayed()))
    }

}