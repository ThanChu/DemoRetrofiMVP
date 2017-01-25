package com.example.thancv.demoretrofimvp.base;

/**
 * Created by ThanCV on 1/25/2017.
 */

public interface BasePresenter<V> {
    void attachView(V view);

    void detachView();
}
