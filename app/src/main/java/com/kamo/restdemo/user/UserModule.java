package com.kamo.restdemo.user;
import com.kamo.restdemo.dao.IRepository;
import com.kamo.restdemo.rxjava.BaseSchedulerProvider;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Jeffrey.Mphahlele on 2/9/2018.
 */
@Module
public abstract class UserModule {

    @Binds
   public  abstract IUser.View getView(ListOfUsersFragment listOfUsersFragment );

    @Provides
    static IUser.Presenter getColorPresente(IUser.View view, IRepository repository, BaseSchedulerProvider provider){
        return new UserPresenterImp(view,repository,provider);
    }

}
