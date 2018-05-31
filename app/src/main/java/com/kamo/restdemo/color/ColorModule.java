package com.kamo.restdemo.color;
import com.kamo.restdemo.dao.IRepository;
import com.kamo.restdemo.di.PerActivity;
import com.kamo.restdemo.rxjava.BaseSchedulerProvider;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Jeffrey.Mphahlele on 1/20/2018.
 */
@Module
public abstract class ColorModule {

    @Binds
    @PerActivity
    abstract IColor.View getView(ListOfColorsFragment listOfColorsFragment);

    @Provides
    static IColor.Presenter getColorPresente(IColor.View view, IRepository repository, BaseSchedulerProvider provider){
        return new ColorPresenterImp(view,repository,provider);
    }

}
