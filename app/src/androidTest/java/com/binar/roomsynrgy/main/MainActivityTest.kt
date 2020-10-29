package com.binar.roomsynrgy.main


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.binar.roomsynrgy.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var mActivityTestRule =  ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun whenFabAddClickedGotoAddActivity() {
        onView(withId(R.id.fabAdd)).perform(click())
    }
}
