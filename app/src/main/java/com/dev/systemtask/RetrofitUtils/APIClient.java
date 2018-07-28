package com.dev.systemtask.RetrofitUtils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sumanth on 7/28/2018.
 */

public class APIClient {

    public static final String BASE_URL = "https://itunes.apple.com/us/rss/topalbums/limit=10/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
