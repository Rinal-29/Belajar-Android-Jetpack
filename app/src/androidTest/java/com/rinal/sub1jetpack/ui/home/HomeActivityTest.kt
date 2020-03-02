package com.rinal.sub1jetpack.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.rinal.sub1jetpack.R
import com.rinal.sub1jetpack.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTv = DataDummy.generateDummyTv()

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.title_content)).check(matches(isDisplayed()))
        onView(withId(R.id.title_content)).check(matches(withText(dummyMovie[0].movieTitle)))
        onView(withId(R.id.desc_content)).check(matches(isDisplayed()))
        onView(withId(R.id.desc_content)).check(matches(withText(dummyMovie[0].movieDesc)))
    }

    @Test
    fun loadTvShow() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadDetailTv() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.title_content)).check(matches(isDisplayed()))
        onView(withId(R.id.title_content)).check(matches(withText(dummyTv[0].tvTitle)))
        onView(withId(R.id.desc_content)).check(matches(isDisplayed()))
        onView(withId(R.id.desc_content)).check(matches(withText(dummyTv[0].tvDesc)))
    }
}