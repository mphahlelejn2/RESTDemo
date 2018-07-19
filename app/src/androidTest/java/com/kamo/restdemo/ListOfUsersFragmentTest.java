package com.kamo.restdemo;
import android.os.SystemClock;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.kamo.restdemo.main.MainActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Created by Jeffrey.Mphahlele on 2018/06/04.
 */
@RunWith(AndroidJUnit4.class)
public class ListOfUsersFragmentTest {

    private static final int ITEM_BELOW_THE_FOLD = 3;


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule=new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkTextDisplayedInDynamicallyCreatedFragment() {

        Espresso.onView(withId(R.id.viewpager)).perform(swipeLeft());
        onView(withId(R.id.user_recycler_view))
                .perform(RecyclerViewActions.scrollToPosition(1));
    }

    @Test
    public void getRecyclerView() throws Exception {
        String itemElementText = "Karianne";
        SystemClock.sleep(800);
        Espresso.onView(withId(R.id.viewpager)).perform(swipeLeft());
        onView(withId(R.id.user_recycler_view)).perform(scrollToPosition(ITEM_BELOW_THE_FOLD));
        onView(withRecyclerView(R.id.user_recycler_view).atPosition( ITEM_BELOW_THE_FOLD)).check(matches(hasDescendant(withText(itemElementText))));
    }


    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }


}
