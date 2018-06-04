package com.kamo.restdemo.main;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.kamo.restdemo.base.BaseActivity;
import com.kamo.restdemo.base.BaseFragment;
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

    public BaseFragment listOfColorsFragment;
    public BaseFragment listOfUsersFragment;


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
        listOfColorsFragment = new ListOfColorsFragment();
        listOfUsersFragment = new ListOfUsersFragment();
        adaptor.addFragment(listOfColorsFragment,"List Of Colors");
        adaptor.addFragment(listOfUsersFragment,"Users");
        viewPager.setAdapter(adaptor);
       // tabLayout.setTabTextColors(R.color.primaryTextColor);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem mSearchMenuItem = menu.findItem(R.id.menu_search);
        SearchView mSearchView = (SearchView) MenuItemCompat.getActionView(mSearchMenuItem);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listOfColorsFragment.filter(newText);
                listOfUsersFragment.filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

}
