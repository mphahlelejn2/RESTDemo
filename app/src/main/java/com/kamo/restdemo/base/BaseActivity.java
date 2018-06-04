package com.kamo.restdemo.base;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.kamo.restdemo.R;

/**
 * Created by Jeffrey.Mphahlele on 5/5/2018.
 */

abstract public class BaseActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.action_settings:
                return true;

        }

        return super.onOptionsItemSelected(item);

    }


}
