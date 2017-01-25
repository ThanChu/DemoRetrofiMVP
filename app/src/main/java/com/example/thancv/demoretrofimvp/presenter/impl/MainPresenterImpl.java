package com.example.thancv.demoretrofimvp.presenter.impl;

import android.content.Context;

import com.example.thancv.demoretrofimvp.aiphelper.APIServiceIml;
import com.example.thancv.demoretrofimvp.listener.FetchDataCallback;
import com.example.thancv.demoretrofimvp.model.Product;
import com.example.thancv.demoretrofimvp.presenter.intface.MainPresenter;
import com.example.thancv.demoretrofimvp.view.intface.MainView;

import java.util.ArrayList;

/**
 * Created by ThanCV on 1/25/2017.
 */

public class MainPresenterImpl implements MainPresenter {
    private MainView view;
    private Context context;
    private APIServiceIml apiServiceIml;

    public MainPresenterImpl(Context context) {
        this.context = context;
    }

    @Override
    public void fetchData() {
        apiServiceIml.getAllProducts(new FetchDataCallback() {
            @Override
            public void fetchDataSuccess(ArrayList<Product> products) {
                view.showData(products);
            }

            @Override
            public void fetchDataFail(Exception e) {

            }
        });
    }

    @Override
    public void attachView(MainView view) {
        this.view = view;
        apiServiceIml = new APIServiceIml();
    }

    @Override
    public void detachView() {
        this.view = null;
        apiServiceIml = null;
    }
}
