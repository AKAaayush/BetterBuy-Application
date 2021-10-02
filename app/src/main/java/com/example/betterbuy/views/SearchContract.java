package com.example.betterbuy.views;

import com.example.betterbuy.models.products.res.ProductRes;

import java.util.List;

public interface SearchContract {

    interface View{
        void getSearchProducts(List<ProductRes> products);

        void onFailed(String message);
    }


    //User Authentication Presenter
    interface Presenter{
        void getSearchProducts(List<ProductRes> products);

        void onFailed(String message);
    }
}
