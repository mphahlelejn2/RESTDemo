package com.kamo.restdemo.color;
import com.kamo.restdemo.base.IBase;
import java.util.List;

/**
 * Created by Jeffrey.Mphahlele on 1/20/2018.
 */

public interface IColor {

    interface Presenter extends IBase.Presenter
    {
        void loadListOfColors();
        void loadColor(int id);
    }
     interface View extends IBase.View
    {
        void loadAdaptor(List<Color> colors);
        void dismissLoadDialog();
        void initLoadProgressDialog();
        void errorLoadingColor();
        void colorListEmpty();

    }

}
