package com.kamo.restdemo.rxjava;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;

/**
 * Created by Jeffrey.Mphahlele on 3/14/2018.
 */

public interface BaseSchedulerProvider {

    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();
}