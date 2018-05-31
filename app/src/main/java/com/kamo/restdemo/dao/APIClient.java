package com.kamo.restdemo.dao;
import com.kamo.restdemo.color.Color;
import com.kamo.restdemo.user.User;

import java.util.List;

import io.reactivex.Maybe;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Jeffrey.Mphahlele on 1/20/2018.
 */

public interface APIClient {

    @GET("/photos")
    Maybe<List<Color>> getColorList();

    @GET("/users")
    Maybe<List<User>>getUserList();

    @GET(UrlManager.API_END_POINT)
    Maybe<Color> getColor(@Path("user")String user);

}
