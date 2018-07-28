package com.dev.systemtask.RetrofitUtils;

import com.dev.systemtask.Model.Data;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Sumanth on 7/28/2018.
 */

public interface APIInterface {

    @GET("json")
    Call<Data> getData();
}
