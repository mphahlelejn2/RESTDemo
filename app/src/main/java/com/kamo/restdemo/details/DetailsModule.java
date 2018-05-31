package com.kamo.restdemo.details;
import com.kamo.restdemo.dao.IRepository;
import com.kamo.restdemo.rxjava.BaseSchedulerProvider;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Jeffrey.Mphahlele on 2/9/2018.
 */
@Module
public abstract class DetailsModule {

    @Binds
    abstract IDetails.View getView(DetailsFragment detailsFragment );

    @Provides
    static IDetails.Presenter getColorPresente(IDetails.View view, IRepository repository, BaseSchedulerProvider provider){
        return new DetailsPresenterImp(view);
    }

}
