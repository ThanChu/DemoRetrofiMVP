package com.example.thancv.demoretrofimvp.listener;

import com.example.thancv.demoretrofimvp.model.Product;

import java.util.ArrayList;

/**
 * Created by ThanCV on 1/25/2017.
 */

public interface FetchDataCallback {
    void fetchDataSuccess(ArrayList<Product> products);

    void fetchDataFail(Exception e);
}
