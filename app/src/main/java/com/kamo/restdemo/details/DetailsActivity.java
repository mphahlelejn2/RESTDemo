package com.kamo.restdemo.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.kamo.restdemo.base.BaseActivity;
import com.kamo.restdemo.utils.ActivityUtils;
import com.kamo.restdemo.R;

/**
 * Created by Jeffrey.Mphahlele on 1/18/2018.
 */

public class DetailsActivity extends BaseActivity{

    private static final String DETAILS = "DETAILS";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FragmentManager fragmentManager = getSupportFragmentManager();

        DetailsFragment detailsFragment = (DetailsFragment) fragmentManager.findFragmentById(R.id.details_fragment);

        if (detailsFragment ==null) {
            detailsFragment = DetailsFragment.newInstance();
            ActivityUtils.addFragment(fragmentManager, detailsFragment, R.id.details_fragment);
        }
    }

}
