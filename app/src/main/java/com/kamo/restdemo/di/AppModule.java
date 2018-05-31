package com.kamo.restdemo.di;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kamo.restdemo.dao.RepositoryImp;
import com.kamo.restdemo.dao.IRepository;
import com.kamo.restdemo.dao.UrlManager;
import com.kamo.restdemo.dao.APIClient;
import com.kamo.restdemo.rxjava.BaseSchedulerProvider;
import com.kamo.restdemo.rxjava.SchedulerProvider;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jeffrey.Mphahlele on 1/20/2018.
 */
@Module
public class AppModule {


    @Provides
    @Singleton
    Gson getGson(){
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    APIClient getRetrofit(Gson gson)
    {
        return new Retrofit.Builder()
                .baseUrl(UrlManager.BASE_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(APIClient.class);
    }

    @Provides
    @Singleton
    IRepository getRepository(APIClient APIClient){
        return new RepositoryImp(APIClient);
    }


    @Provides
    @Singleton
    BaseSchedulerProvider getBaseSchedulerProvider(){
        return SchedulerProvider.getInstance();
    }

    @Provides
    static CompositeDisposable getCompositeDisposable(){
        return new CompositeDisposable();
    }
}
