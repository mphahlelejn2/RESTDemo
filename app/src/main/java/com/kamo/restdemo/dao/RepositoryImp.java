package com.kamo.restdemo.dao;

import com.kamo.restdemo.color.Color;
import com.kamo.restdemo.data.remote.Injection;
import com.kamo.restdemo.user.User;

import java.util.List;
import javax.inject.Inject;
import io.reactivex.Maybe;

/**
 * Created by Jeffrey.Mphahlele on 1/21/2018.
 */

public class RepositoryImp implements IRepository {

    private static String TAG="RepositoryImp";

    public APIClient APIClient;

    @Inject
    public RepositoryImp(APIClient APIClient) {
        this.APIClient = APIClient;
        //this.APIClient = Injection.provideColorsApiClient();;
    }

    @Override
    public  Maybe<List<Color>> getColorList() {
        return APIClient.getColorList();
    }

    @Override
    public  Maybe<List<User>> getUserList() {
        return APIClient.getUserList();
    }

    @Override
    public Maybe<Color> getColor(String colorName) {
        return APIClient.getColor(colorName);
    }

}
