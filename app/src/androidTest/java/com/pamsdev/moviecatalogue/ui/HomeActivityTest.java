package com.pamsdev.moviecatalogue.ui;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.pamsdev.moviecatalogue.R;
import com.pamsdev.moviecatalogue.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4ClassRunner.class)
public class HomeActivityTest {

    @Before
    public void setup() {
        ActivityScenario.launch(HomeActivity.class);
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition(20));
    }

    @Test
    public void loadTv() {
        onView(withId(R.id.navigation_tv)).perform(click());
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.scrollToPosition(20));
    }

    @Test
    public void loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.iv_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_release)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_description)).check(matches(isDisplayed()));
    }

    @Test
    public void loadDetailTv() {
        onView(withId(R.id.navigation_tv)).perform(click());
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.iv_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_release)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_description)).check(matches(isDisplayed()));
    }

}