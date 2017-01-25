package com.example.thancv.demoretrofimvp.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ThanCV on 1/25/2017.
 */

public class Product {
    @SerializedName("id_product")
    public int idProduct;
    @SerializedName("product_name")
    public String productName;
    @SerializedName("decription")
    public String decription;
    @SerializedName("price")
    public String price;
    @SerializedName("thumnail")
    public String thumnail;

    private static Product getProduct(JSONObject jsonObject) {
        return new Gson().fromJson(jsonObject.toString(), Product.class);
    }

    public static ArrayList<Product> getAllProduct(JSONArray jsonArray) throws JSONException {
        ArrayList<Product> arrayList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            arrayList.add(getProduct(jsonArray.getJSONObject(i)));
        }
        return arrayList;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getThumnail() {
        return thumnail;
    }

    public void setThumnail(String thumnail) {
        this.thumnail = thumnail;
    }
}
