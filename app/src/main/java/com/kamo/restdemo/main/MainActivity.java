package com.kamo.restdemo.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.kamo.restdemo.base.BaseActivity;
import com.kamo.restdemo.color.ListOfColorsFragment;
import com.kamo.restdemo.user.ListOfUsersFragment;
import com.kamo.restdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.viewpager)
    public ViewPager viewPager;
    @BindView(R.id.tabs)
    public TabLayout tabLayout;
    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    public ListOfColorsFragment listOfBooksFragment;
    public ListOfUsersFragment listOfUsersFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setUpPager();
        tabLayout.setupWithViewPager(viewPager);
    }



    private void setUpPager() {
        TabsAdapter adaptor = new TabsAdapter(getSupportFragmentManager());
        assert viewPager != null;
        viewPager.setOffscreenPageLimit(2);
        listOfBooksFragment = new ListOfColorsFragment();
        listOfUsersFragment = new ListOfUsersFragment();
        adaptor.addFragment(listOfBooksFragment,"List Of Colors");
        adaptor.addFragment(listOfUsersFragment,"Users");
        viewPager.setAdapter(adaptor);
       // tabLayout.setTabTextColors(R.color.primaryTextColor);
    }




}
