package com.kamo.restdemo.data.remote;


import com.kamo.restdemo.dao.APIClient;

/**
 * Created by Jeffrey.Mphahlele on 25/05/2018.
 */

public class Injection {
    private static APIClient apiClient;

    public static APIClient provideColorsApiClient() {
        if (apiClient == null) {
            apiClient = new TestApiClient();
        }
        return apiClient;
    }
}
