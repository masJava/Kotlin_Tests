package com.geekbrains.tests.espresso


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.geekbrains.tests.R
import com.geekbrains.tests.TEST_NUMBER_OF_RESULTS_FAKE_404
import com.geekbrains.tests.TEST_NUMBER_OF_RESULTS_FAKE_MINUS_1
import com.geekbrains.tests.view.search.MainActivity
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class TestRecorder {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testRecorder() {
        onView(allOf(withId(R.id.searchEditText))).perform(replaceText("qwe"), closeSoftKeyboard())

        onView(allOf(withId(R.id.findButton))).perform(click())

        onView(allOf(withId(R.id.totalCountTextView)))
            .check(matches(withText(TEST_NUMBER_OF_RESULTS_FAKE_404)))

        onView(allOf(withId(R.id.toDetailsActivityButton))).perform(click())

        onView(allOf(withId(R.id.totalCountDetailsTextView)))
            .check(matches(withText(TEST_NUMBER_OF_RESULTS_FAKE_404)))

        onView(allOf(withId(R.id.decrementButton))).perform(click())

        onView(allOf(withId(R.id.totalCountDetailsTextView)))
            .check(matches(withText(TEST_NUMBER_OF_RESULTS_FAKE_MINUS_1)))

        onView(allOf(withId(R.id.incrementButton))).perform(click())

        onView(allOf(withId(R.id.totalCountDetailsTextView)))
            .check(matches(withText(TEST_NUMBER_OF_RESULTS_FAKE_404)))
    }
}
