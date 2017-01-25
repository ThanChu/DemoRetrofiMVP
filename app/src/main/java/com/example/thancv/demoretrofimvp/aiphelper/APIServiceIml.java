package com.example.thancv.demoretrofimvp.aiphelper;

import com.example.thancv.demoretrofimvp.listener.FetchDataCallback;
import com.example.thancv.demoretrofimvp.model.Product;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ThanCV on 1/25/2017.
 */

public class APIServiceIml {
    private static final String TAG = APIServiceIml.class.getSimpleName();
    private APIService apiService;

    public void getAllProducts(final FetchDataCallback fetchDataCallback) {
        apiService = APIService.retrofit.create(APIService.class);
        Call<ResponseBody> getProduct = apiService.getAllProduct();
        getProduct.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    JSONArray jsonArray = new JSONArray(response.body().string());
                    fetchDataCallback.fetchDataSuccess(Product.getAllProduct(jsonArray));
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                fetchDataCallback.fetchDataFail(new Exception(t));
            }
        });
    }
}
