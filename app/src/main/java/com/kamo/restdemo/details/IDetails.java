package com.kamo.restdemo.details;


import android.content.Context;
import android.widget.ImageView;

import com.kamo.restdemo.base.IBase;
import com.kamo.restdemo.color.Color;

/**
 * Created by Jeffrey.Mphahlele on 2/7/2018.
 */

public interface IDetails {

    interface Presenter extends IBase.Presenter
    {
        void loadInfo(Color color, ImageView imageView);
    }

    interface View extends IBase.View
    {
        Context getContext();
    }
}
