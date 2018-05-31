package com.kamo.restdemo.color;

import android.app.Activity;

import com.kamo.restdemo.base.IBase;

import java.util.List;

/**
 * Created by Jeffrey.Mphahlele on 1/20/2018.
 */

public interface IColor {

    interface Presenter extends IBase.Presenter
    {
        void loadListOfColors();
        void loadColor(String name);
    }
     interface View extends IBase.View
    {
        void loadAdaptor(List<Color> colors);
        Activity getActivity();
        void dismissLoadDialog();
        void initLoadProgressDialog();
        void errorLoadingColor();
        void colorListEmpty();
    }

}
