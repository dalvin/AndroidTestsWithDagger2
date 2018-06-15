package com.dalvinlabs.mylibrary

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

  private val testActivityRule = ActivityTestRule(TestActivity::class.java, true, true)

  @Rule
  fun rule() = testActivityRule

  @Test
  fun firstTest() {
    onView(withId(R.id.fragment_library_text_view)).check(matches(isDisplayed()))
    Thread.sleep(60000L)
  }
}
