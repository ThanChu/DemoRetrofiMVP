package com.example.thancv.demoretrofimvp.view;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.thancv.demoretrofimvp.R;
import com.example.thancv.demoretrofimvp.adapter.ProductAdapter;
import com.example.thancv.demoretrofimvp.base.BaseActivity;
import com.example.thancv.demoretrofimvp.model.Product;
import com.example.thancv.demoretrofimvp.presenter.impl.MainPresenterImpl;
import com.example.thancv.demoretrofimvp.view.intface.MainView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private RecyclerView.LayoutManager layoutManager;
    private ProductAdapter productAdapter;
    private MainPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenterImpl(this);
        productAdapter = new ProductAdapter(this);
        layoutManager = new GridLayoutManager(this, 2);

        presenter.attachView(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(productAdapter);
    }

    @OnClick(R.id.btnGetData)
    public void getData() {
        presenter.fetchData();
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showData(ArrayList<Product> products) {
        productAdapter.fetchData(products);
    }

    @Override
    public void showMessage(String message) {

    }
}
