package com.kamo.restdemo.user;

import com.kamo.restdemo.base.IBase;

import java.util.List;

/**
 * Created by Jeffrey.Mphahlele on 1/20/2018.
 */

public interface IUser {

    public interface Presenter extends IBase.Presenter
    {
        void loadFullAuthorList();
        void destroy();
    }

    public interface View extends IBase.View
    {
        void loadAdaptor(List<User> colors);
        void dismissLoadDialog();
        void initLoadProgressDialog();
        void ErrorloadingFullAuthorList();
        void emptyAuthorList();
    }
}
