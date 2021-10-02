package com.example.betterbuy.views;

import com.example.betterbuy.models.products.Category;
import com.example.betterbuy.models.products.Product;
import com.example.betterbuy.models.products.res.ProductRes;

import java.util.List;

public interface HomeContract {

    interface View{
        void getLatestProducts(List<ProductRes> products);
        void getCategories(List<Category> categories);
        void getExclusiveProducts(List<Product> products);
        void onFailed(String message);
    }


    //User Authentication Presenter
    interface Presenter{
        void getLatestProducts(List<ProductRes> products);
        void getCategories(List<Category> categories);
        void getExclusiveProducts(List<Product> products);
        void onFailed(String message);
    }
}
