package com.example.xinyuan.comp2100_frogger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
//@RunWith(AndroidJUnit4.class)
//public class restartScreenTest {
//    @Rule
//    public ActivityTestRule<GameActivity> gameActivityActivityTestRule =
//            new ActivityTestRule<>(GameActivity.class);
//    @Test
//    public void restartButtonClick() throws Exception{
//        onView(withId(R.id.restart)
//                .perform(click());
//        onView(withId(R.id.play))
//                .check();
//
//
//    }
//
//}