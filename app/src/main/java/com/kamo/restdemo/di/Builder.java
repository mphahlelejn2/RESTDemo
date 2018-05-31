package com.kamo.restdemo.di;

import com.kamo.restdemo.color.ColorModule;
import com.kamo.restdemo.details.DetailsModule;
import com.kamo.restdemo.details.DetailsFragment;
import com.kamo.restdemo.color.ListOfColorsFragment;
import com.kamo.restdemo.user.ListOfUsersFragment;
import com.kamo.restdemo.user.UserModule;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Jeffrey.Mphahlele on 4/8/2018.
 */
@Module(includes = AndroidInjectionModule.class)
public abstract class Builder {
    @PerActivity
    @ContributesAndroidInjector(modules = DetailsModule.class)
    abstract DetailsFragment bindColorDetailsFragment();

    @PerActivity
    @ContributesAndroidInjector(modules = ColorModule.class)
    abstract ListOfColorsFragment bindListOfColorsFragment();

    @PerActivity
    @ContributesAndroidInjector(modules = UserModule.class)
    abstract ListOfUsersFragment bindListOfUsersFragment();
}
