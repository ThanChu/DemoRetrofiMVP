package com.example.thancv.demoretrofimvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thancv.demoretrofimvp.R;
import com.example.thancv.demoretrofimvp.model.Product;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ThanCV on 1/25/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {
    private List<Product> listProduct = new ArrayList<>();
    private Context context;

    public ProductAdapter(Context context) {
        this.context = context;
    }

    public void fetchData(List<Product> listProduct) {
        this.listProduct = listProduct;
        notifyDataSetChanged();
    }

    @Override
    public ProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductHolder holder, int position) {
        Product products = listProduct.get(position);
        holder.txtName.setText(products.getProductName());
        Glide.with(context).load(products.getThumnail())
                .centerCrop()
                .into(holder.imgThumnal);
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    class ProductHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_Thumnail)
        ImageView imgThumnal;
        @BindView(R.id.tv_Name)
        TextView txtName;

        public ProductHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}


