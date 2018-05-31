package com.kamo.restdemo.rxjava;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jeffrey.Mphahlele on 3/14/2018.
 */

public class SchedulerProvider implements BaseSchedulerProvider {

    @Nullable
    private static SchedulerProvider INSTANCE;

    // Prevent direct instantiation.
    private  SchedulerProvider() {
    }

    public static synchronized  SchedulerProvider getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SchedulerProvider();
        }
        return INSTANCE;
    }

    @Override
    @NonNull
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    @NonNull
    public  Scheduler io() {
        return Schedulers.io();
    }

    @Override
    @NonNull
    public  Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}