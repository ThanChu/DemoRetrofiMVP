package com.example.thancv.demoretrofimvp.presenter.intface;

import com.example.thancv.demoretrofimvp.base.BasePresenter;
import com.example.thancv.demoretrofimvp.view.intface.MainView;

import java.util.ArrayList;

/**
 * Created by ThanCV on 1/25/2017.
 */

public interface MainPresenter extends BasePresenter<MainView> {
    void fetchData();
}
