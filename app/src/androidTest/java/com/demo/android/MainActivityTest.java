package com.demo.android;

import android.content.Context;
import android.util.Log;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.demo.android.view.MenuActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    public static final String TAG = "MainActivityTest";
    private Context mContext;

    @Before
    public void prepare() {
        mContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
    }

    @Rule
    public ActivityTestRule<MenuActivity> mActivityTestRule = new ActivityTestRule<>(MenuActivity.class);

    @Test
    public void test() {

        Log.e(TAG, "test: " + mContext.getPackageName());
        Espresso.onView(ViewMatchers.withId(R.id.btn_click_intent))
                .perform(ViewActions.click());
        Espresso.pressBack();
    }


}