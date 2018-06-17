package com.kamo.restdemo.data.remote;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kamo.restdemo.color.Color;
import com.kamo.restdemo.dao.APIClient;
import com.kamo.restdemo.user.User;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Maybe;

/**
 * Created by Jeffrey.Mphahlele on 25/05/2018.
 */

public class TestApiClient implements APIClient {


    @Override
    public Maybe<List<Color>> getColorList() {
        List<Color> colorList= new Gson().fromJson(TestData.jsonListOfColors, new TypeToken<List<Color>>(){}.getType());
        return Maybe.just(colorList).delay(1, TimeUnit.SECONDS);
    }

    @Override
    public Maybe<List<User>> getUserList() {
        List<User> userList= new Gson().fromJson(TestData.jsonListOfUsers, new TypeToken<List<User>>(){}.getType());
        return Maybe.just(userList).delay(1, TimeUnit.SECONDS);
    }

    @Override
    public Maybe<Color> getColor(String user) {
        List<Color> colorList= new Gson().fromJson(TestData.jsonListOfColors, new TypeToken<List<Color>>(){}.getType());
        return Maybe.just(colorList.get(0)).delay(1, TimeUnit.SECONDS);
    }
}
