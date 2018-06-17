package com.kamo.restdemo;
import android.os.SystemClock;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.kamo.restdemo.color.ListOfColorsFragment;
import com.kamo.restdemo.main.MainActivity;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;



/**
 * Created by Jeffrey.Mphahlele on 2018/06/04.
 */
@RunWith(AndroidJUnit4.class)
public class ListOfColorsFragmentTest  {

    private static final String TITLE = "reprehenderit est deserunt velit ipsam";
    private static final int ITEM_BELOW_THE_FOLD = 3;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule=new ActivityTestRule<>(MainActivity.class);


    @Test
    public void getRecyclerView() throws Exception {
        String itemElementText = "culpa odio esse rerum omnis laboriosam voluptate repudiandae";
        SystemClock.sleep(800);
        onView(withId(R.id.color_recycler_view)).perform(scrollToPosition(ITEM_BELOW_THE_FOLD));
        onView(withRecyclerView(R.id.color_recycler_view).atPosition( ITEM_BELOW_THE_FOLD)).check(matches(hasDescendant(withText(itemElementText))));
    }

    @Test
    public void checkTextDisplayedInDynamicallyCreatedFragment() {

        SystemClock.sleep(800);
        Espresso.onView(withId(R.id.viewpager)).perform(swipeRight());
        onView(withId(R.id.color_recycler_view)).perform(
                RecyclerViewActions.actionOnItemAtPosition(1, MyViewAction.clickChildViewWithId(R.id.view)));


        onView(withId(R.id.summary)).check(matches(isDisplayed()));
        onView(withId(R.id.summary)).check(matches(withText(TITLE)));

    }

    public static class MyViewAction {

        public static ViewAction clickChildViewWithId(final int id) {
            return new ViewAction() {
                @Override
                public Matcher<View> getConstraints() {
                    return null;
                }

                @Override
                public String getDescription() {
                    return "Click on a child view with specified id.";
                }

                @Override
                public void perform(UiController uiController, View view) {
                    View v = view.findViewById(id);
                    v.performClick();
                }
            };
        }

    }


    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }


}
