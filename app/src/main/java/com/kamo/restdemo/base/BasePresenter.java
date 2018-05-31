package com.kamo.restdemo.base;
import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by Jeffrey.Mphahlele on 5/5/2018.
 */

abstract public class BasePresenter implements IBase.Presenter {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void destroy() {
        compositeDisposable.clear();
    }
}
