package com.example.thancv.demoretrofimvp.view.intface;

import com.example.thancv.demoretrofimvp.model.Product;

import java.util.ArrayList;

/**
 * Created by ThanCV on 1/25/2017.
 */

public interface MainView{
    void showData(ArrayList<Product> products);

    void showMessage(String message);
}
