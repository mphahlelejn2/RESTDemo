package com.kamo.restdemo.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * Created by Jeffrey.Mphahlele on 2/9/2018.
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface UserScope {
}
