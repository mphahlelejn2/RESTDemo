package com.kamo.restdemo.user;

import com.kamo.restdemo.dao.IRepository;
import com.kamo.restdemo.base.BasePresenter;
import com.kamo.restdemo.rxjava.BaseSchedulerProvider;

import java.util.List;
import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableMaybeObserver;

/**
 * Created by Jeffrey.Mphahlele on 2/9/2018.
 */

public class UserPresenterImp extends BasePresenter implements IUser.Presenter {

    private IUser.View view;
    private static String TAG="UserPresenterImp";

    private IRepository repository;
    private BaseSchedulerProvider scheduler;
    CompositeDisposable compositeDisposable=new CompositeDisposable();

    @Inject
    public UserPresenterImp(IUser.View view, IRepository repository, BaseSchedulerProvider scheduler) {
        this.view=view;
        this.repository=repository;
        this.scheduler=scheduler;
    }

    @Override
    public void loadFullAuthorList() {
        view.initLoadProgressDialog();
        compositeDisposable.add(repository.getUserList()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .subscribeWith(new DisposableMaybeObserver<List<User>>() {

                    @Override
                    public void onSuccess(List<User> users) {
                        view.loadAdaptor(users);
                        view.dismissLoadDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.ErrorloadingFullAuthorList();
                    }

                    @Override
                    public void onComplete() {
                        view.emptyAuthorList();
                    }
                }));

    }



}
