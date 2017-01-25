package com.example.thancv.demoretrofimvp.aiphelper;

import com.example.thancv.demoretrofimvp.config.Constant;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by ThanCV on 1/25/2017.
 */

public interface APIService {
    @GET("getallproducts.php")
    Call<ResponseBody> getAllProduct();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constant.URL_PRODUCT)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
