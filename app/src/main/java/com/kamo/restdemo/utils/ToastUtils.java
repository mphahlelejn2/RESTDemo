package com.kamo.restdemo.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Jeffrey.Mphahlele on 5/11/2018.
 */

public class ToastUtils {
    public static void showShortMessage(Context c,String msg){
        Toast.makeText(c,msg,Toast.LENGTH_SHORT).show();
    }
}
