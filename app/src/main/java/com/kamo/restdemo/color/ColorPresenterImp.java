package com.kamo.restdemo.color;
import com.kamo.restdemo.dao.IRepository;
import com.kamo.restdemo.base.BasePresenter;
import com.kamo.restdemo.rxjava.BaseSchedulerProvider;

import java.util.List;
import javax.inject.Inject;

import io.reactivex.observers.DisposableMaybeObserver;

/**
 * Created by Jeffrey.Mphahlele on 1/20/2018.
 */

public class ColorPresenterImp extends BasePresenter implements IColor.Presenter {

    private IColor.View view;
    private static String TAG="ColorPresenterImp";
    private IRepository repository;
    private BaseSchedulerProvider scheduler;
    
     @Inject
    public ColorPresenterImp(IColor.View view, IRepository repository, BaseSchedulerProvider scheduler) {
        this.view=view;
        this.repository=repository;
        this.scheduler=scheduler;
    }

    @Override
    public void loadListOfColors() {
        view.initLoadProgressDialog();
        compositeDisposable.add(repository.getColorList()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .subscribeWith(new DisposableMaybeObserver<List<Color>>() {

                                   @Override
                                   public void onSuccess(List<Color> colors) {
                                       view.loadAdaptor(colors);
                                       view.dismissLoadDialog();
                                   }

                                   @Override
                                   public void onError(Throwable e) {
                                    view.errorLoadingColor();
                                   }

                                   @Override
                                   public void onComplete() {
                                       view.colorListEmpty();
                                   }
                               }

                ));

    }

    @Override
    public void loadColor(String name) {
        compositeDisposable.add(repository.getColor(name)
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .subscribeWith(new DisposableMaybeObserver() {


                    @Override
                    public void onSuccess(Object o) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }));

    }


}
