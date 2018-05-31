package com.kamo.restdemo.dao;

import com.kamo.restdemo.color.Color;
import com.kamo.restdemo.user.User;
import java.util.List;
import io.reactivex.Maybe;


/**
 * Created by Jeffrey.Mphahlele on 1/21/2018.
 */

public interface IRepository {
    Maybe<List<Color>> getColorList();
    Maybe<List<User>> getUserList();
    Maybe<Color> getColor(String colorName);
}
